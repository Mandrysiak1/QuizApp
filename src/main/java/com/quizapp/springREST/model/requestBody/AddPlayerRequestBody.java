package com.quizapp.springREST.model.requestBody;

public class AddPlayerRequestBody {

    private String username;
    private String lobbyId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLobbyId() {
        return lobbyId;
    }

    public void setLobbyId(String lobbyId) {
        this.lobbyId = lobbyId;
    }
}
