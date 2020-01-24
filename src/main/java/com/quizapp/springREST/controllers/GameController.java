package com.quizapp.springREST.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    @Autowired
    private SimpMessagingTemplate messageSender;

//    @Autowired
//    GameService service;
//
//


//    @MessageMapping("{game}")
//    public void simple(@DestinationVariable String game) {
//
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAA WYKONANE");
//        messageSender.convertAndSend("/topic/websocket/game/", new Message("idk","lol " + game));
//    }
//    @SubscribeMapping("{game}")
//    public Message complex(@DestinationVariable String game) {
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAA ZASUBSKRYBOWANO");
//        return new Message("xd to dziala xd chyba nie iwem","tak");
//    }

    @MessageMapping("/greeting")
    public String handle(String greeting) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAA WYKONANE");
            return "[" + "Xd" + " " + greeting;
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


