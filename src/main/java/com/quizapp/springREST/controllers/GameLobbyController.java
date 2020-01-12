package com.quizapp.springREST.controllers;


import com.quizapp.springREST.Model.Lobby;
import com.quizapp.springREST.services.GameLobbyService;
import com.quizapp.springREST.responses.NewLobbyResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/lobby")
public class GameLobbyController {


    private GameLobbyService gameController = new GameLobbyService();

    @GetMapping("/new")
    public NewLobbyResponse startNewLobby()
    {
        return new NewLobbyResponse(gameController.createLobby().getId());
    }


    @RequestMapping(value = "/getAllLobbies",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<Lobby> getAllLobbies()
    {

        return gameController.returnAllLobbies();

    }



}
