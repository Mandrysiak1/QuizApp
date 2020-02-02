package com.quizapp.springREST.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@RestController
class SocketController {

    @Autowired
    SocketService socketService;

    @Autowired private SimpUserRegistry simpUserRegistry;

    @MessageMapping("/games/{game_id}")
    @SendTo("/topic/games/{game_id}")
    EchoModel echoMessageMapping(@DestinationVariable String game_id, String message) {
       String x = message + game_id + "ASADADADADSADSAD===============================================================================================";
        System.out.println(x);
        socketService.echoMessage(x.trim(),game_id);
        System.out.println(simpUserRegistry.getUsers() + "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
                return new EchoModel(x.trim());
    }

    @RequestMapping(value = "/hello-convert-and-send", method = RequestMethod.POST)
    void echoConvertAndSend(@RequestParam("msg") String message) {
        //socketService.echoMessage(message);
    }

    @EventListener
    public void handleSessionSubscribeEvent(SessionSubscribeEvent event) {
        GenericMessage message = (GenericMessage) event.getMessage();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA + SUBSKRYPCJA " + message);
        String simpDestination = (String) message.getHeaders().get("simpDestination");

        if (simpDestination.startsWith("/topic/group/1")) {
            // do stuff
        }
    }
}
