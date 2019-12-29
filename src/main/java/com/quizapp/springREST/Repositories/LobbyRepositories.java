package com.quizapp.springREST.Repositories;

import com.quizapp.springREST.Model.Lobby;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class LobbyRepositories {

    @Getter
    private ArrayList<Lobby> lobbies = new ArrayList<>();

    public void addLobby(Lobby lobby)
    {
        lobbies.add(lobby);
    }

    public ArrayList<Lobby> getAllLobbies()
    {
        return lobbies;
    }





}
