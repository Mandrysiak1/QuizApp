package com.quizapp.springREST.model;

public class NewGameBody {
    private String userID;
    private String gameID;

    public String getUserID() { return userID; }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }


}
