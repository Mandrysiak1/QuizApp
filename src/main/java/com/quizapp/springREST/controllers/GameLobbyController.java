package com.quizapp.springREST.controllers;


import com.quizapp.springREST.model.requestBody.AddPlayerRequestBody;
import com.quizapp.springREST.model.requestBody.GetAllLobbyRequestBody;
import com.quizapp.springREST.model.requestBody.NewLobbyRequestBody;
import com.quizapp.springREST.model.serverResponse.NewLobbyResponse;
import com.quizapp.springREST.services.GameLobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/lobby")
public class GameLobbyController {



    @Autowired
    private GameLobbyService gameController;

    @PostMapping("/new")
    public ResponseEntity startNewLobby(@RequestBody NewLobbyRequestBody body )
    {
        return ok(new NewLobbyResponse(gameController.createLobby(body.getSocID(),body.getPlayerName()).getId()));
    }

    @PostMapping("/getAllLobbies")
    public ResponseEntity getAllLobbies(@RequestBody GetAllLobbyRequestBody body)
    {
        return ok(gameController.returnAllLobbies(body.getSocID()));
    }

    @GetMapping("/addPlayer")
    public ResponseEntity addPlayer(@RequestBody AddPlayerRequestBody body){
        gameController.addPlayer(body.getLobbyId(),body.getUsername());
        return ok(true);
    }





}
