package com.quizapp.springREST.managers;

import com.quizapp.springREST.Model.Lobby;
import com.quizapp.springREST.Model.Player;

public class GameLobbyManager {


    public Lobby createLobby()
    {
        return new Lobby();
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
