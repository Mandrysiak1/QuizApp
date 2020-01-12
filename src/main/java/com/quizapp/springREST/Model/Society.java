package com.quizapp.springREST.Model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@Getter
@Document(collection = "societies")
public class Society {

    @Id
    private String id;

    private String Name;

    private HashSet<User> users = new HashSet<>();

    private HashMap<User, ArrayList<Quest>> UserToQuest = new HashMap<>();


    public Society(String name) {
        Name = name;
    }
}