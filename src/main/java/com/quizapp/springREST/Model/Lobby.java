package com.quizapp.springREST.Model;


import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.HashSet;


@Getter
public class Lobby {

//    @Autowired
//    @Qualifier("sessionRegistry")
//    private SessionRegistry sessionRegistry;

    @Getter
    private HashSet<User> players;
    @Id
    private String id;

    public Lobby() {
        players = new HashSet<>();


    }


    public boolean addPlayer(User player)
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

