package com.quizapp.springREST.model.requestBody;

import com.quizapp.springREST.model.objects.Question;

public class QuestionBody {
    private String socID;
    private Question question;

    public String getSocID() {
        return socID;
    }

    public void setSocID(String socID) {
        this.socID = socID;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
