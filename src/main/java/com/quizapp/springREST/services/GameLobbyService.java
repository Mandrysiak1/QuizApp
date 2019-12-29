package com.quizapp.springREST.services;

import com.quizapp.springREST.Model.Lobby;
import com.quizapp.springREST.Model.Player;
import com.quizapp.springREST.Repositories.LobbyRepositories;

import java.util.ArrayList;

public class GameLobbyService {


    private LobbyRepositories repositories = new LobbyRepositories();

    public Lobby createLobby()
    {

        Lobby lobby = new Lobby();

        repositories.addLobby(lobby);

        return lobby;
    }

    public ArrayList<Lobby> returnAllLobbies()
    {
        return repositories.getLobbies();
    }


    public void addPlayer(Player player,Lobby lobby){

        if(!lobby.addPlayer(player)){
            throw new  IllegalArgumentException("Player in lobby already");
        }
    }

    public void removePlayer(Player player, Lobby lobby)
    {
        if(!lobby.removePlayer(player)){
            throw new IllegalArgumentException("Player not in lobby");
        }
    }

    public void startGame(Lobby lobby)
    {

    }

}
