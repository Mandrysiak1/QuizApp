package com.quizapp.springREST.controllers;

class EchoModel {

    EchoModel(String echo) {
        this.echo = echo;
    }
    String echo;

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }
}
