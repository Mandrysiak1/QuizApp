package com.quizapp.springREST.services;

import com.quizapp.springREST.Repositories.GameRepository;
import com.quizapp.springREST.Repositories.LobbyRepository;
import com.quizapp.springREST.Repositories.QuestionRepository;
import com.quizapp.springREST.model.PlayerAnswers;
import com.quizapp.springREST.model.objects.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void  startNewGame(String lobbyID) {

        Lobby lobby = lobbyRepository.getLobbyByID(lobbyID);
        Game game = new Game(lobby, randomQuestion(lobby.getSocietyID()));
        gameRepository.AddNewGame(game);
        lobbyRepository.removeLobby(lobbyID);

        Timer timer = new Timer();

        int begin = 0;
        int timeInterval = 60000;

        timer.schedule(new TimerTask() {

            int counter = 1;

            @Override
            public void run() {

                if (counter != 1) {

                    game.proceedAnswers();
                }
                game.roundNumber = counter;
                game.currentQuestion = game.getQuestions().get((counter -1)) ;

                //game.getGameState();
                sendGameState(game.getGs(), game.getGame_id());
                counter++;
                if (counter >= 11) {
                    timer.cancel();
                    sendGameState(game.getGs(),game.getGame_id());
//                    proceedGameEnd(game);
                }
            }


        }, begin, timeInterval);
    }


//    private void proceedGameEnd(Game game) {
//        rankingSerice.update(game.getGameState());
//        questService.update(game.getGameState());
//        gameRepository.removeGame(game);
//
//    }

    public ArrayList<Question> randomQuestion(String id) {

        ArrayList<Question>  q =  questionRepository.findAllBySocID(id).stream().map(QuestionEntity::getQuestion).collect(Collectors.toCollection(ArrayList::new));
        return getRandomElement(q,questionCount);

    }

    public ArrayList<Question> getRandomElement(List<Question> list, int totalItems)
    {
        Random rand = new Random();

        ArrayList<Question> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {
            int randomIndex = rand.nextInt(list.size());
            newList.add(list.get(randomIndex));
            list.remove(randomIndex);
        }
        return newList;
    }

    public void sendGameState(GameState gameState, String game_id) {
        socketService.echoMessage(gameState, game_id);
    }
    public void postAnswers(PlayerAnswers body) {
         gameRepository.getActiveGameByID(body.getGameID()).addAnswers(body);
    }
}
