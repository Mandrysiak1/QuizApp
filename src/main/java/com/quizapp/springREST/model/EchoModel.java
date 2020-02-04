package com.quizapp.springREST.model;

public class EchoModel {

    public EchoModel(String echo) {
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
