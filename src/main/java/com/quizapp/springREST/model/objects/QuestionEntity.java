package com.quizapp.springREST.model.objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "questions")
public class QuestionEntity {

    @Id
    private String id;

    private String socID;

    @Field("question")
    private Question question;

    public QuestionEntity(String socID, Question questions) {
        this.socID = socID;
        this.question = questions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
