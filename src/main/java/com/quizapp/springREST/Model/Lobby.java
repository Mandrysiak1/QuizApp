package com.quizapp.springREST.Model;


import lombok.Getter;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.IdGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class Lobby {

//    @Autowired
//    @Qualifier("sessionRegistry")
//    private SessionRegistry sessionRegistry;

    @Getter
    private Set<Player> players;

    @Getter
    private UUID uuid;

    public Lobby() {
        players = new HashSet<>();

        IdGenerator generator = new AlternativeJdkIdGenerator();
        uuid = generator.generateId();
    }


    public boolean addPlayer(Player player)
    {
        return players.add(player);
    }

    public boolean removePlayer(Player player){

        return  players.remove(player);
    }

//
//    public List<Player> getLoggedUsers() {
//
//
//        ArrayList<User> users = new ArrayList<>();
//
//        final List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
//
//        for (final Object principal : allPrincipals) {
//            if (principal instanceof User) {
//                final User user = (User) principal;
//
//                users.add(user);
//
//            }
//        }
//        return users.stream().map(x -> new Player(x.getId())).collect(Collectors.toList());
//    }


    public void StartGame(){

    }

}

