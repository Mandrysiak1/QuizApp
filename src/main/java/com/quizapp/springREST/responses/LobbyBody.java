package com.quizapp.springREST.responses;

import java.util.List;

public class LobbyBody {

    private List<String> playersNames;

    private String ID;

    public LobbyBody(List<String> playersNames, String ID) {
        this.playersNames = playersNames;
        this.ID = ID;
    }

    public List<String> getPlayersNames() {
        return playersNames;
    }

    public void setPlayersNames(List<String> playersNames) {
        this.playersNames = playersNames;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
