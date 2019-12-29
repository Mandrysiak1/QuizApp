package com.quizapp.springREST.Repositories;

import com.quizapp.springREST.Model.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class GameRepository {

    private ArrayList<Game> activeGames = new ArrayList<>();

    public void AddNewGame( Game game)
    {
        activeGames.add(game);
    }

}
