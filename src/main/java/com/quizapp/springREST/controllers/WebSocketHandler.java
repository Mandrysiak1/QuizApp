package com.quizapp.springREST.controllers;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import java.io.IOException;
public class WebSocketHandler extends AbstractWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String msg = String.valueOf(message.getPayload());
        // Send back unique message depending on the id received from the client

        System.out.println( String.valueOf(message.getPayload()) + "=========================================================================================");
        session.sendMessage(new TextMessage("XD"));
        }
    }
