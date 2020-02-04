package com.quizapp.springREST.Repositories;

import com.quizapp.springREST.model.objects.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class GameRepository {

    private ArrayList<Game> activeGames = new ArrayList<>();

    public Game AddNewGame( Game game)
    {
        activeGames.add(game);
        return game;
    }

    public Game getActiveGameByID(String game_id)
    {
        return activeGames.stream().filter(e -> e.getGame_id().equals(game_id)).findFirst().orElse(null);
    }
}
