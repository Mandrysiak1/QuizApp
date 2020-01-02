package com.quizapp.springREST.Model;

import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.HashSet;

@Getter
public class Game {

    @Id
    private String id;

    private HashSet<User> players;
    private InGameRanking ranking;
    private Integer roundNumber;
    private Question currentQuestion;

    public Game(HashSet<User> players) {
        this.players = players;
        StartGame();
    }

    private void StartGame() {

    }


    public GameState getGameState() {
        return new GameState(roundNumber,currentQuestion,ranking);
    }

    public Game proceedAnserws(PlayerAnswers answers) {

        //TODO:implementation

        return  this;
    }

    public GameState startNextRound() {
        roundNumber ++;
        //TODO:Change the question
        //TODO:Update ranking
        return getGameState();
    }
}
