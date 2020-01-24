package com.quizapp.springREST.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GameController {

    @Autowired
    private SimpMessagingTemplate messageSender;

    @MessageMapping("/hello-msg-mapping")
    @SendTo("/topic/greetings")
    public String echoMessageMapping(String message) {
        messageSender.convertAndSend("/topic/greetings", "xdxdxd");
        System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
        log.debug("React to hello-msg-mapping");
        return message + " była tya djsoklm";
    }


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

/*    @MessageMapping("/greetings")
    public String handle(String greeting) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAA WYKONANE");
        messageSender.convertAndSend("/topic/greetings", new Message("idk","lol "));
            return "[" + "Xd" + " " + greeting;
        }*/
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


