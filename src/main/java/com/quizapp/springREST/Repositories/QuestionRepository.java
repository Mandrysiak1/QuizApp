package com.quizapp.springREST.Repositories;

import com.quizapp.springREST.model.objects.QuestionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface QuestionRepository extends MongoRepository<QuestionEntity,String>
{
    QuestionEntity findBySocID(String id);

    void deleteById(String s);

    ArrayList<QuestionEntity> findAllBySocID(String id);
}
