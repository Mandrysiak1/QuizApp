package com.quizapp.springREST.model.objects;

import com.quizapp.springREST.model.PlayerAnswers;
import com.quizapp.springREST.services.GameService;
import com.quizapp.springREST.services.SocketService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


@Configurable
@Getter
public class Game {


    private int goodAnswerPoints = 10;

    @Autowired
    GameService gameService;


    @Autowired
    SocketService socketService;

    private String game_id;
    private GameState gs;
    private Lobby lobby;
    private InGameRanking ranking;
    public int roundNumber = 0;
    private ArrayList<Question> questions;
    public Question currentQuestion;
    private int currentQuestionCounter = -1;

    private HashSet<Question> questionHashset = new HashSet<>();

    HashSet<PlayerAnswers> answers;
    public Game(Lobby lobby, ArrayList<Question> questions) {
        System.out.println("START aNEW GAME CSTR)"
        );
        this.lobby = lobby;
        this.game_id = lobby.getId();
        this.questions = questions;
        if(this.questionHashset == null)
            System.out.println("pls kill me");
            else System.out.println(this.questions.size() + " <- size of question in cstr");


        System.out.println(questions.size() + " <- size of question passed in cstr");
        if(lobby ==null)
        {
            System.out.println("to to");

        }else {
            System.out.println("to nie to: " + lobby.getId());
        }

        this.ranking = new InGameRanking();
        startGame();
    }

    private void startGame() {
       // currentQuestion = questions.get(0);


        System.out.println("Start new Game");
    }


    public void getGameState() {
        System.out.println("into get gameState");
        gs = new GameState(roundNumber,currentQuestion,ranking);
    }

    public boolean addAnswers(PlayerAnswers x){

        return answers.add(x);

    }



    public void proceedAnserws() {

        HashMap<String,Boolean> isCorrect = new HashMap<String, Boolean>();

        for (PlayerAnswers x : answers) {

            if(x.getAnswer() == currentQuestion.properAnswer)
            {
                ranking.getRanking().put(x.getUserID(),ranking.getRanking().get(x.getUserID()) + goodAnswerPoints );
                isCorrect.put(x.getUserID(),true);
            }else
            {
                isCorrect.put(x.getUserID(),false);
            }
        }

        for (PlayerAnswers y : answers){

            for(String g : isCorrect.keySet())
            {
                if(y.getPlayerToInteger().get(g) < 0 && isCorrect.get(g) == false)
                {
                    ranking.getRanking().put(y.getUserID(),ranking.getRanking().get(y.getUserID()) + Math.abs(y.getPlayerToInteger().get(g)) );
                }else if(y.getPlayerToInteger().get(g) < 0 && isCorrect.get(g) == true)
                {
                    ranking.getRanking().put(y.getUserID(),ranking.getRanking().get(y.getUserID()) - Math.abs(y.getPlayerToInteger().get(g)));
                }else if(y.getPlayerToInteger().get(g) > 0 && isCorrect.get(g) == true)
                {
                    ranking.getRanking().put(y.getUserID(),ranking.getRanking().get(y.getUserID()) + Math.abs(y.getPlayerToInteger().get(g)) );
                }else if(y.getPlayerToInteger().get(g) > 0 && isCorrect.get(g) == false)
                {
                    ranking.getRanking().put(y.getUserID(),ranking.getRanking().get(y.getUserID()) - Math.abs(y.getPlayerToInteger().get(g)) );
                }
            }
        }

    }

    private synchronized  void startNextRound() {

        //return getGameState();
    }
}
