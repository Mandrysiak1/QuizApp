package com.quizapp.springREST.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
class SocketService {

    @Autowired
    private SimpMessagingTemplate simpTemplate;

    public void echoMessage(String message,String game_id) {
        System.out.println("++++++++++++++++++++++++++++++" + game_id);
        simpTemplate.convertAndSend("/topic/games/"+game_id, new EchoModel(message));

    }
}
