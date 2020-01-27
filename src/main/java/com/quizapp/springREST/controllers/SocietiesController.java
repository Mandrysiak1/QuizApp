package com.quizapp.springREST.controllers;

import com.quizapp.springREST.Model.Society;
import com.quizapp.springREST.Model.User;
import com.quizapp.springREST.Repositories.UserRepository;
import com.quizapp.springREST.responses.SocietyResponse;
import com.quizapp.springREST.services.SocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.InvalidKeyException;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/society")
public class SocietiesController {

    @Autowired
    SocietyService societyManager;
    @Autowired
    UserRepository userRepository;


    @PostMapping("/create")
    public void CreateNewSociety(@RequestParam String name ,@RequestParam String login)
    {
        Society newSociety = new Society(name);
        User user = userRepository.findByEmail(login);
        if (user == null) throw new InvalidKeyException("nie znaleziono użytkownika");
        newSociety.addUser(userRepository.findByEmail(login));
        societyManager.saveSociety(newSociety);
    }

    @GetMapping("/getUserSocieties")
    public ResponseEntity getUserSocieties(@RequestBody SocietyRequest login)
    {
        SocietyResponse societies;
        societies  =  societyManager.getAllSocietesRelatedToUser(userRepository.findByEmail(login.name));

        return ok(societies);
    }

    @PostMapping("/leaveSociety")
    public void LeaveSociety(@RequestParam String soc_id,@RequestParam String user_id)
    {
        societyManager.leaveSociety(userRepository.findById(user_id).get(),societyManager.getSocietyByID(soc_id));

    }



}
