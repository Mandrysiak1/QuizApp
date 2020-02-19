package com.quizapp.springREST.services;

import com.quizapp.springREST.Repositories.QuestionRepository;
import com.quizapp.springREST.model.objects.Question;
import com.quizapp.springREST.model.objects.QuestionEntity;
import com.quizapp.springREST.model.serverResponse.AllQuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public AllQuestionResponse getAllQuestionsReletedToSoc(String socID)
    {

        return new AllQuestionResponse(questionRepository.findAllBySocID(socID));

    }

}
