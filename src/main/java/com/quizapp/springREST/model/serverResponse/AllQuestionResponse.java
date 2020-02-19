package com.quizapp.springREST.model.serverResponse;

import com.quizapp.springREST.model.objects.QuestionEntity;

import java.util.List;

public class AllQuestionResponse {

    private List<QuestionEntity> questions;

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    public AllQuestionResponse(List<QuestionEntity> questions) {
        this.questions = questions;
    }
}
