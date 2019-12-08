package com.quizapp.springREST.controllers;


import com.quizapp.springREST.Model.Lobby;
import com.quizapp.springREST.Repositories.LobbyRepositories;
import com.quizapp.springREST.responses.NewLobbyResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/lobby")
public class GameLobbyController {


    private LobbyRepositories repositories = new LobbyRepositories();

    @GetMapping("/new")
    public NewLobbyResponse startNewLobby()
    {

        Lobby lobby = new Lobby();

        repositories.addLobby(lobby);

        return new NewLobbyResponse(lobby.getUuid());

    }

    @GetMapping("/getAllLobbies")
    public List<Lobby> getAllLobbies()
    {

        return repositories.getAllLobbies();
    }

}
