package com.quizapp.springREST.model;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class PlayerAnswers {

    String userID;

    String gameID;

    Character answer;

    HashMap<String,Integer> PlayerToInteger = new HashMap<>(); // - nie zgadnie + zgadnie , 0 brak obstawienia

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public Character getAnswer() {
        return answer;
    }

    public void setAnswer(Character answer) {
        this.answer = answer;
    }

    public HashMap<String, Integer> getPlayerToInteger() {
        return PlayerToInteger;
    }

    public void setPlayerToInteger(HashMap<String, Integer> playerToInteger) {
        PlayerToInteger = playerToInteger;
    }
}


