package com.quizapp.springREST.model.objects;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class Question {

    public Question(String text, HashMap<Character, String> answers, Character properAnswer) {
        this.text = text;
        this.answers = answers;
        this.properAnswer = properAnswer;
    }

//    @Id
//    String id;

    String text;
    HashMap<Character,String> answers = new HashMap<>();
    Character properAnswer;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HashMap<Character, String> getAnswers() {
        return answers;
    }

    public void setAnswers(HashMap<Character, String> answers) {
        this.answers = answers;
    }

    public Character getProperAnswer() {
        return properAnswer;
    }

    public void setProperAnswer(Character properAnswer) {
        this.properAnswer = properAnswer;
    }
}
