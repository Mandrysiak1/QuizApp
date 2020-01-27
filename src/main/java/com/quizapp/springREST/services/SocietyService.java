package com.quizapp.springREST.services;


import com.quizapp.springREST.Model.Quest;
import com.quizapp.springREST.Model.Society;
import com.quizapp.springREST.Model.User;
import com.quizapp.springREST.Repositories.SocietyRepository;
import com.quizapp.springREST.responses.SocEntity;
import com.quizapp.springREST.responses.SocietyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("SocietyManager")
public class SocietyService {

    @Autowired
    SocietyRepository repository;


    public Society getSocietyByID(String id){

        Optional<Society> soc = repository.findById(id);
        if(soc.isPresent())
        {
            return soc.get();
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void saveSociety(Society society)
    {
        repository.save(society);
    }

    public SocietyResponse getAllSocietesRelatedToUser(User user){

        SocietyResponse societies = new SocietyResponse();

        List<Society> societies1 = repository.findAll();
//        return repository.findAll().stream().filter(e->e.getUsers().contains(user))
//                                    .collect(Collectors.toList());

        for (Society x: repository.findAll()
             ) {
            if(x.getUsers().contains(user)){
                societies.getSocietiesEntities().add(new SocEntity(x.getName(),x.getId()));
            }


        }

        return societies;
    }

    public void leaveSociety(User user,Society society)
    {
        society.removeUser(user);
    }

    @Scheduled(cron = "0 0 12 * * ?")
    private void ChangeDailyQuests()
    {
        for (Society society : repository.findAll()){
            {
                society.getUserToQuest().clear();
                for (User user :society.getUsers()) {

                    society.getUserToQuest().put(user,generateNewQuests());
                }
            }


    }
    }

    private ArrayList<Quest> generateNewQuests(){
        //TODO:IMPLEMENTATION REQUIRED
        ArrayList<Quest>  quests = new ArrayList<>();
        return quests;
    }


}
