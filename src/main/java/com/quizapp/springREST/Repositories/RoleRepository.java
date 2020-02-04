package com.quizapp.springREST.Repositories;

import com.quizapp.springREST.model.objects.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {

    Role findByRole(String role);
}
