package com.quizapp.springREST.services;

import com.quizapp.springREST.Model.Lobby;
import com.quizapp.springREST.Model.Player;
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

    public Lobby createLobby(String socID)
    {

        Lobby lobby = new Lobby(socID);

        lobby.addPlayer(userRepository.findByEmail("aaa@email.com"));

        repositories.addLobby(lobby);

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


    public void addPlayer(String lobbyID, String playerID){

        if(!repositories.GetLobbyByID(lobbyID).addPlayer(userRepository.findByEmail(playerID))){
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
