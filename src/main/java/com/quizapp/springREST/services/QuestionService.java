package com.quizapp.springREST.services;

import com.quizapp.springREST.model.objects.Question;
import com.quizapp.springREST.model.objects.QuestionEntity;
import com.quizapp.springREST.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuestionService {


    @Autowired
    QuestionRepository questionRepository;


    public void addToRepository(String socID, Question question)
    {
        questionRepository.save(new QuestionEntity(socID,question));
    }

    public void removeFromRepostitory(String questionID){

        questionRepository.deleteById(questionID);
    }

    public ArrayList<QuestionEntity> getAllQuestionsReletedToSoc(String socID)
    {
        return questionRepository.findAllBySocID(socID);

    }

}
