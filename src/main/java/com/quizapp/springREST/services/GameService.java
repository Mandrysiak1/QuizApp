package com.quizapp.springREST.services;

import com.quizapp.springREST.Model.Game;
import com.quizapp.springREST.Model.Lobby;
import com.quizapp.springREST.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameService {

    private Lobby lobby;

    @Autowired
    GameLobbyService gameLobbyService;

    @Autowired
    GameRepository gameRepository;

    public void startNewGame(String lobbyID)
    {
        gameRepository.AddNewGame(new Game(gameLobbyService.getLobbyById(lobbyID).getPlayers()));
    }





}
