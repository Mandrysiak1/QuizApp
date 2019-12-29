package com.quizapp.springREST.responses;

import lombok.Getter;

import java.util.UUID;

public class NewLobbyResponse {

    @Getter
    private String lobbyID;

    public NewLobbyResponse(UUID lobbyID) {
        this.lobbyID = lobbyID.toString();
    }
}
