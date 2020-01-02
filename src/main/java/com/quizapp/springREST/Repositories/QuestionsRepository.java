package com.quizapp.springREST.Repositories;

import com.quizapp.springREST.Model.Question;
import com.quizapp.springREST.Model.Society;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface QuestionsRepository extends MongoRepository<Society,ArrayList<Question>>
{
}
