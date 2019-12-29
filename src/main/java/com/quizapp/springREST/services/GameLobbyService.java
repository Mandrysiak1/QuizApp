package com.quizapp.springREST.services;

import com.quizapp.springREST.Model.Lobby;
import com.quizapp.springREST.Model.Player;
import com.quizapp.springREST.Model.User;
import com.quizapp.springREST.Repositories.LobbyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameLobbyService {


    private LobbyRepository repositories = new LobbyRepository();

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


    public void addPlayer(User player, Lobby lobby){

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

  public Lobby getLobbyById(String ID){
      return  repositories.GetLobbyByID(ID);
  }
}
