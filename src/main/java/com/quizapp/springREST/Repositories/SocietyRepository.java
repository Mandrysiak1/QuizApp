package com.quizapp.springREST.Repositories;

import com.quizapp.springREST.Model.Society;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SocietyRepository extends MongoRepository<Society,String> {

    @Override
    List<Society> findAll();

    @Override
    Optional<Society> findById(String s);





}
