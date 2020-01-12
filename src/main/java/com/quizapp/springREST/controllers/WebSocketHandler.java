package com.quizapp.springREST.controllers;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;

public class WebSocketHandler extends AbstractWebSocketHandler {

    @SubscribeMapping("/games/{game_id}")
    public String subscribeToGame(
            @DestinationVariable(value = "game_id") String game_id) {

        return "aaa " + game_id;
    }
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String msg = String.valueOf(message.getPayload());
        // Send back unique message depending on the id received from the client

        System.out.println( String.valueOf(message.getPayload()) + "=========================================================================================");
        session.sendMessage(new TextMessage("XD"));
        }
    }
