package com.quizapp.springREST.services;

import com.quizapp.springREST.model.objects.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SocketService {

    @Autowired
    private SimpMessagingTemplate simpTemplate;

    public void echoMessage(GameState message, String game_id) {
        System.out.println("+++++++++++++++++++++++++++++as+" + game_id);
        if(simpTemplate == null)
        {
            System.out.println("nie chce zyc" +
                    "");
        }
        simpTemplate.convertAndSend("/topic/games/"+game_id , new GameState(message.getRoundNumber(),message.getQuestion(),message.getRanking()));

    }
}
