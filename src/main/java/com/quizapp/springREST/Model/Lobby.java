package com.quizapp.springREST.Model;


import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.HashSet;


@Getter
public class Lobby {

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User owner;
    @Getter
    private HashSet<User> players;


    @Id
    private String id;

    private String societyID;

    public Lobby(String society) {
        players = new HashSet<>();
        this.societyID = society;
        this.id = NanoIdUtils.randomNanoId();
    }




    public boolean addPlayer(User player)
    {
        return players.add(player);
    }


    public boolean removePlayer(User player){

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

