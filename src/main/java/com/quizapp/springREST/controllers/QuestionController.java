package com.quizapp.springREST.controllers;


import com.quizapp.springREST.model.objects.QuestionEntity;
import com.quizapp.springREST.model.requestBody.QuestionBody;
import com.quizapp.springREST.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/questions")
public class QuestionController {

@Autowired
private QuestionService service;

    @PostMapping("/getAllQuestionsToSociety")
    public List<QuestionEntity> getAllQuestions(@RequestBody QuestionBody question)
    {
       return service.getAllQuestionsReletedToSoc(question.getSocID());
    }

    @PostMapping("/addQuestion")
    public ResponseEntity addQuestion(@RequestBody QuestionBody question)
    {

        service.addToRepository(question.getSocID(),question.getQuestion());

        return ok(true);
    }

    @PostMapping("removeQuestion")
    public ResponseEntity deleteQuestions(@RequestParam String questionID){

        service.removeFromRepostitory(questionID);
        return ok(true);
    }


}
