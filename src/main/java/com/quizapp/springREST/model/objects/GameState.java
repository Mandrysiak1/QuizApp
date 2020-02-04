package com.quizapp.springREST.model.objects;

public class GameState {
    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public InGameRanking getRanking() {
        return ranking;
    }

    public void setRanking(InGameRanking ranking) {
        this.ranking = ranking;
    }

    private int roundNumber;
    private Question question;
    private InGameRanking ranking;

    public GameState(int roundNumber, Question question, InGameRanking ranking) {
        this.roundNumber = roundNumber;
        this.question = question;
        this.ranking = ranking;
        System.out.println("prosze ");
    }
}
