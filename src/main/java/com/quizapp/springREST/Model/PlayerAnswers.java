package com.quizapp.springREST.Model;

import lombok.Getter;

import java.util.HashMap;
@Getter
public class PlayerAnswers {
    Character answer;

    HashMap<User,Integer> PlayerToInteger = new HashMap<>(); // - nie zgadnie + zgadnie , 0 brak obstawienia
}


