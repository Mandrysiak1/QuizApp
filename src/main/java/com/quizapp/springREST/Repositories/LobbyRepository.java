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

        lobbies.forEach(e -> System.out.println(e.getId()));
        System.out.println(lobbies.size() + "as");
        for (Lobby x : lobbies)
        {
            System.out.println(x.getId() + "KOZA " + ID);
            if(x.getId().equals(ID))
            {

                return  x;
            }
        }

        return  null;
        //return lobbies.stream().filter(lobby -> ID.equals(lobby.getId())).findFirst().orElse(null);
    }



}
