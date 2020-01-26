package com.quizapp.springREST.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SocketController {

    @Autowired
    SocketService socketService;

    @MessageMapping("/games/{game_id}")
    @SendTo("/topic/games/{game_id}")
    EchoModel echoMessageMapping(@DestinationVariable String game_id, String message) {
       String x = message + game_id + "ASADADADADSADSAD";
        return new EchoModel(x.trim());
    }

    @RequestMapping(value = "/hello-convert-and-send", method = RequestMethod.POST)
    void echoConvertAndSend(@RequestParam("msg") String message) {
        socketService.echoMessage(message);
    }
}
