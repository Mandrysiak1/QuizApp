package com.quizapp.springREST.services;


import com.quizapp.springREST.Model.Quest;
import com.quizapp.springREST.Model.Society;
import com.quizapp.springREST.Model.User;
import com.quizapp.springREST.Repositories.SocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Society> getAllSocietesRelatedToUser(User user){

        return repository.findAll().stream().filter(e->e.getUsers().contains(user))
                                    .collect(Collectors.toList());

    }

    public void leaveSociety(User user,Society society)
    {
        society.getUsers().remove(user);
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
