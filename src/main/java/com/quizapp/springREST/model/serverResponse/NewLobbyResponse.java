package com.quizapp.springREST.model.serverResponse;

import lombok.Getter;

public class NewLobbyResponse {

    @Getter
    private String lobbyID;

    public NewLobbyResponse(String lobbyID) {
        this.lobbyID = lobbyID;
    }
}
