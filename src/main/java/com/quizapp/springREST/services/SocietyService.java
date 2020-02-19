package com.quizapp.springREST.services;


import com.quizapp.springREST.Repositories.SocietyRepository;
import com.quizapp.springREST.model.objects.Quest;
import com.quizapp.springREST.model.objects.Society;
import com.quizapp.springREST.model.objects.User;
import com.quizapp.springREST.model.serverResponse.SocietyEntity;
import com.quizapp.springREST.model.serverResponse.SocietyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("SocietyManager")
public class SocietyService {

    @Autowired
    SocietyRepository repository;

    public Society getSocietyByID(String id){

        Optional<Society> soc = repository.findById(id);

        if(soc.isPresent()) { return soc.get();}
        else{ throw new IllegalArgumentException(); }
    }

    public void saveSociety(Society society)
    {
        repository.save(society);
    }
    public void removeSociety(String socID)
    {
        repository.deleteById(socID);
    }

    public SocietyResponse getAllSocietiesRelatedToUser(User user){

        SocietyResponse societies = new SocietyResponse();

        for (Society x: repository.findAll()) {
            if(x.getUsers().contains(user)){
                societies.getSocietiesEntities().add(new SocietyEntity(x.getName(),x.getId()));
            }
        }
        return societies;
    }

    public void leaveSociety(User user,Society society)
    {
        society.removeUser(user);
    }

    public void addToSociety(User user, Society society) {
        society.addUser(user);
        repository.save(society);
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
