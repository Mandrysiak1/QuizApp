package com.quizapp.springREST.controllers;

public class SocietyRequest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SocietyRequest(String name) {
        this.name = name;
    }
}
