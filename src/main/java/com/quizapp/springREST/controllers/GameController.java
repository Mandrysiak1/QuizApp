package com.quizapp.springREST.controllers;

import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {


//    @Autowired
//    GameService service;
//
//
    @SubscribeMapping("/games/123")
    public String subscribeToGame() {

        return "aaa " + 123;
    }
//
//
//    @MessageMapping("/games/{game_id}/start")
//    @SendTo("/games/{game_id}")
//    public GameState startGame(
//            @DestinationVariable(value = "game_id") String game_id){
//
//             return service.startNewGame(game_id).getGameState();
//    }
//
//    @MessageMapping("/games/{game_id}/ans")
//    public void sendAnserws(@DestinationVariable(value = "game_id") String game_id,
//                            @Payload PlayerAnswers answers){
//
//            service.proceedAnserws(game_id,answers);
//
//    }
//
//    public void nextRound(String game_id){
//
//        service.sendMessage("/games/{game_id}",service.GetGameByGameID(game_id).startNextRound());
//      //this.template.convertAndSend("/games/{game_id}",service.GetGameByGameID(game_id).startNextRound());
//    }
//


}


