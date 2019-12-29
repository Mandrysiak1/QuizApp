package com.quizapp.springREST.Repositories;

import com.quizapp.springREST.Model.Question;
import com.quizapp.springREST.Model.Society;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public interface QuestionsRepository extends MongoRepository<HashMap<Society, ArrayList<Question>>,String>
{
}
