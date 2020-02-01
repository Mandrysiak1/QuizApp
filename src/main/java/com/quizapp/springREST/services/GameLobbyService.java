package com.quizapp.springREST.services;

import com.quizapp.springREST.Model.Lobby;
import com.quizapp.springREST.Model.User;
import com.quizapp.springREST.Repositories.LobbyRepository;
import com.quizapp.springREST.Repositories.UserRepository;
import com.quizapp.springREST.responses.AllLobbyResponse;
import com.quizapp.springREST.responses.LobbyBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class GameLobbyService {


    @Autowired
    UserRepository userRepository;

    private LobbyRepository repositories = new LobbyRepository();

    public Lobby createLobby(String socID,String playerName)
    {

        Lobby lobby = new Lobby(socID);
        lobby.setOwner(userRepository.findByEmail(playerName));
        repositories.addLobby(lobby);
        addPlayer(lobby.getId(),userRepository.findByEmail(playerName).getEmail());



        return lobby;
    }

    public AllLobbyResponse returnAllLobbies(String socID)
    {

        ArrayList<Lobby> x =  repositories.getLobbies().stream().filter(e -> e.getSocietyID().equals(socID)).collect(Collectors.toCollection(ArrayList::new));

        System.out.println("X: " + x.size());

            System.out.println("SOCID: " + socID);

        ArrayList<LobbyBody> bodies = new ArrayList<>();

        for (Lobby z : x) {
            bodies.add(new LobbyBody(z.getPlayers().stream().map(User::getEmail).collect(Collectors.toList()), z.getId()));
        }

        if(bodies.size() == 0)
            System.out.println("NO JEBŁO PANIE I TO GALANCIE");
        for (LobbyBody z :
                bodies) {
            System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS: " + z.getPlayersNames().size()    );
        }
        return new AllLobbyResponse(bodies);
    }


    public void addPlayer(String lobbyID, String playerName){


        Lobby x = repositories.getLobbies().stream().
                filter(e -> e.getPlayers().contains(userRepository.findByEmail(playerName) ) ).
                findAny().orElse(null);

        if( x != null)
        {
           x.removePlayer(userRepository.findByEmail(playerName));
           repositories.GetLobbyByID(lobbyID).addPlayer(userRepository.findByEmail(playerName));
        }else
        {
            repositories.GetLobbyByID(lobbyID).addPlayer(userRepository.findByEmail(playerName));
        }
    }

    public void removePlayer(User player, Lobby lobby)
    {
        if(!lobby.removePlayer(player)){
            throw new IllegalArgumentException("Player not in lobby");
        }else if(player == lobby.getOwner())
        {
            removeLobby(lobby.getId());
        }else{
            lobby.removePlayer(player);
        }
    }

    private void removeLobby(String id) {

        repositories.removeLobby(id);
    }


    public Lobby getLobbyById(String ID){
      return  repositories.GetLobbyByID(ID);
  }
}
