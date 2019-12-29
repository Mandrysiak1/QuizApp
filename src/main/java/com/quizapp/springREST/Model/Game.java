package com.quizapp.springREST.Model;

import java.util.HashSet;

public class Game {

    private HashSet<User> players;

    public Game(HashSet<User> players) {
        this.players = players;
        StartGame();
    }

    private void StartGame() {

    }


}
