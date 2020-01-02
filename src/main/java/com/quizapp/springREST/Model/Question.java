package com.quizapp.springREST.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
@Getter
@Setter
@AllArgsConstructor
public class Question {
    String text;
    HashMap<Character,String> answers = new HashMap<>();
}
