package com.quizapp.springREST.Repositories;

import com.quizapp.springREST.model.objects.Lobby;
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
        lobbies.remove(getLobbyByID(lobbyID));
    }
    public ArrayList<Lobby> getAllLobbies()
    {
        return lobbies;
    }

    public Lobby getLobbyByID(String ID){

        System.out.println(ID + "fnind");
        for (Lobby x : lobbies)
        {
            if(x.getId().equals(ID))
            {
                System.out.println(x.getId() + "KOZA " + ID);
                return  x;
            }
        }
        //return lobbies.stream().filter(lobby -> ID.equals(lobby.getId())).findFirst().orElse(null);
    }



}
