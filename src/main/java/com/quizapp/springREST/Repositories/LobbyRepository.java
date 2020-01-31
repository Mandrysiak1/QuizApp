package com.quizapp.springREST.Repositories;

import com.quizapp.springREST.Model.Lobby;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LobbyRepository {

    @Getter
    private ArrayList<Lobby> lobbies = new ArrayList<>();

    public void addLobby(Lobby lobby)
    {
        lobbies.add(lobby);
    }

    public void removeLobby(String lobbyID){
        lobbies.remove(GetLobbyByID(lobbyID));
    }
    public ArrayList<Lobby> getAllLobbies()
    {
        return lobbies;
    }

    public Lobby GetLobbyByID(String ID){

        return lobbies.stream().filter(e->e.getId().equals(ID)).findFirst().orElse(null);
    }



}
