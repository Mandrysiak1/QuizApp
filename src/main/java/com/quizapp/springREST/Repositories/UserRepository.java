package com.quizapp.springREST.Repositories;

import com.quizapp.springREST.model.objects.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    User findByEmail(String email);

    Optional<User> findById(String id);

    @Override
    void deleteById(String s);
}
