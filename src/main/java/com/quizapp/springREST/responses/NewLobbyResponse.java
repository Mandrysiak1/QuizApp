package com.quizapp.springREST.responses;

import lombok.Getter;

public class NewLobbyResponse {

    @Getter
    private String lobbyID;

    public NewLobbyResponse(String lobbyID) {
        this.lobbyID = lobbyID;
    }
}
