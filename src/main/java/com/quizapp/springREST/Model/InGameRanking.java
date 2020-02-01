package com.quizapp.springREST.Model;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class InGameRanking {
    HashMap<User,Integer> ranking;
}
