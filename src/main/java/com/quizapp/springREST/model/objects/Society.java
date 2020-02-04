package com.quizapp.springREST.model.objects;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@Getter
@Document(collection = "societies")
public class Society {

    @Id
    private String id;

    @Field(value="Name")
    private String name;

    @DBRef
    private HashSet<User> users = new HashSet<>();


    private HashMap<User, ArrayList<Quest>> userToQuest = new HashMap<>();

    @PersistenceConstructor
    public Society(String id, String name, HashSet<User> users, HashMap<User, ArrayList<Quest>> userToQuest) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.userToQuest = userToQuest;
    }


    public Society(String name) {
        this.name = name;
    }
    public void addUser(User x)
    {
        users.add(x);
    }
    public void removeUser( User x)
    {
        users.remove(x);
    }

}
