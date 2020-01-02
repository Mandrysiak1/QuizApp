package com.quizapp.springREST.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameState {

    private int roundNumber;
    private Question question;
    private InGameRanking ranking;

}
