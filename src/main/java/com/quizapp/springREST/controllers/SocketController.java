package com.quizapp.springREST.controllers;


import com.quizapp.springREST.model.NewGameBody;
import com.quizapp.springREST.model.PlayerAnswers;
import com.quizapp.springREST.services.GameService;
import com.quizapp.springREST.services.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SocketController {

    @Autowired
    SocketService socketService;

    @Autowired
    GameService gameService;

    @MessageMapping("/games/{game_id}")
    @SendTo("/topic/games/{game_id}")
    void echoMessageMapping(@DestinationVariable String game_id, String message) {
       String x = message + game_id + "ASADADADAhjhDSADSAD===============================================================================================";
        System.out.println(x);
    }

    @PostMapping("/games/{game_id}/new_game")
    void startNewGame(@RequestBody NewGameBody body) {

        gameService.startNewGame(body.getGameID());
    }
    @PostMapping("/games/{game_id}/post_answers")
    void postAnserws(@RequestBody PlayerAnswers body )
    {
        gameService.postAnswers(body);
    }


}
