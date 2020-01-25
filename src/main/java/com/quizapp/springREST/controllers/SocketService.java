package com.quizapp.springREST.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
class SocketService {

    @Autowired
    private SimpMessagingTemplate simpTemplate;

    public void echoMessage(String message) {
        System.out.println("aasd");
        simpTemplate.convertAndSend("/topic/greetings", new EchoModel(message));

    }
}
