package com.quizapp.springREST.responses;

import java.util.List;

public class AllLobbyResponse {

    private List<LobbyBody> lobbies;

    public List<LobbyBody> getLobbies() {
        return lobbies;
    }

    public void setLobbies(List<LobbyBody> lobbies) {
        this.lobbies = lobbies;
    }

    public AllLobbyResponse(List<LobbyBody> lobbies) {
        this.lobbies = lobbies;
    }
}
