package com.quizapp.springREST.services;

import com.quizapp.springREST.model.*;
import com.quizapp.springREST.Repositories.GameRepository;
import com.quizapp.springREST.Repositories.LobbyRepository;
import com.quizapp.springREST.Repositories.QuestionRepository;
import com.quizapp.springREST.model.objects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class GameService {

    private int questionCount = 10;

    @Autowired
    GameRepository gameRepository;
    @Autowired
    LobbyRepository lobbyRepository;
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    SocketService socketService;
    @Autowired
    private SimpMessagingTemplate simpTemplate;


    public void startNewGame(String lobbyID)
    {

        Lobby lobby  = lobbyRepository.getLobbyByID(lobbyID);
        Game game = new Game(lobby,randomQuestion(lobby.getSocietyID()));
        gameRepository.AddNewGame(game);

        Timer timer = new Timer();

        int begin = 0;
        int timeInterval = 60000;


        timer.schedule(new TimerTask() {

            int counter = 0;
            @Override
            public void run() {
                System.out.println("Sheduler worked xd");
                if(counter != 0){

                    game.proceedAnserws();
                }

                System.out.println("no jestem se tuitaj siem amordasiod ofasd kutas");
                game.roundNumber ++;
                System.out.println(game.getQuestions().size() + " <-questions size");
                System.out.println(game.getQuestions().get((game.getCurrentQuestionCounter())+2).getText() + "<- thats a question text");
                game.currentQuestion = game.getQuestions().get((game.getCurrentQuestionCounter())+2);

                System.out.println();
//                if(simpTemplate == null) System.out.println("1") ;else if( game_id == null) System.out.println("2"); else  if(gs ==null)
//                    System.out.println("3"); else
//                    System.out.println("ty no nie wiem jak tam twoja szmaciura");;
//                simpTemplate.convertAndSend("/topic/games/" + game_id, gs);
                //gameService.sendGameState(gs,game_id);
                //startNextRound();

                sendGameState(game.getGs(),game.getGame_id());
                counter++;
                if (counter >= 20){
                    timer.cancel();
                }
            }
        }, begin, timeInterval);


    }

    public ArrayList<Question> randomQuestion(String id) {


        System.out.println("random questions");
        ArrayList<Question>  q =  questionRepository.findAllBySocID(id).stream().map(QuestionEntity::getQuestion).collect(Collectors.toCollection(ArrayList::new));

        System.out.println(q.size() + " <- question array size in randomQuestions");

        return getRandomElement(q,questionCount);

    }

    public ArrayList<Question> getRandomElement(List<Question> list, int totalItems)
    {
        Random rand = new Random();

        // create a temporary list for storing
        // selected element
        ArrayList<Question> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {

            // take a raundom index between 0 to size
            // of given List
            int randomIndex = rand.nextInt(list.size());

            // add element in temporary list
            newList.add(list.get(randomIndex));

            // Remove selected element from orginal list
            list.remove(randomIndex);
        }
        return newList;
    }

    public void sendGameState(GameState gameState, String game_id) {
        System.out.println("++++++++++++++++++++++++++++++" + game_id);
        socketService.echoMessage(gameState,game_id);
        simpTemplate.convertAndSend("/topic/games/"+game_id, gameState);

    }

    public void postAnswers(PlayerAnswers body) {
         gameRepository.getActiveGameByID(body.getGameID()).addAnswers(body);
    }
}
