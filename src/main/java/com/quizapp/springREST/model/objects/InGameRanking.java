package com.quizapp.springREST.model.objects;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class InGameRanking {
    HashMap<String,Integer> ranking = new HashMap<>();

}
