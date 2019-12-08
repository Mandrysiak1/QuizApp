package com.quizapp.springREST.responses;

import java.util.UUID;

public class NewLobbyResponse {

    private String lobbyID;

    public NewLobbyResponse(UUID lobbyID) {
        this.lobbyID = lobbyID.toString();
    }
}
