package com.quizapp.springREST.controllers;

import com.quizapp.springREST.Repositories.UserRepository;
import com.quizapp.springREST.model.objects.Society;
import com.quizapp.springREST.model.objects.User;
import com.quizapp.springREST.model.requestBody.SocietyRequestBody;
import com.quizapp.springREST.model.serverResponse.SocietyResponse;
import com.quizapp.springREST.services.SocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public ResponseEntity CreateNewSociety(@RequestParam String name ,@RequestParam String login)
    {
        Society newSociety = new Society(name);
        User user = userRepository.findByEmail(login);
        if (user == null) throw new InvalidKeyException("nie znaleziono użytkownika");
        newSociety.addUser(userRepository.findByEmail(login));
        return ok(true);
    }

    @PostMapping("/getUserSocieties")
    public ResponseEntity getUserSocieties(@RequestBody SocietyRequestBody login)
    {
        SocietyResponse societies;
        societies  =  societyManager.getAllSocietiesRelatedToUser(userRepository.findByEmail(login.getName()));

        return ok(societies);
    }

    @PostMapping("/leaveSociety")
    public ResponseEntity LeaveSociety(@RequestParam String soc_id,@RequestParam String user_id)
    {
        User user;
        if(userRepository.findById(user_id).isPresent())
             user = userRepository.findById(user_id).get();
        else return new ResponseEntity(HttpStatus.BAD_REQUEST);

        societyManager.leaveSociety(user,societyManager.getSocietyByID(soc_id));

        return ok(true);
    }

    @PostMapping("/addUserToSociety")
    public ResponseEntity AddUserToSociety(@RequestParam String soc_id,@RequestParam String user_id)
    {
        User user;
        if(userRepository.findById(user_id).isPresent())
            user = userRepository.findById(user_id).get();
        else return new ResponseEntity(HttpStatus.BAD_REQUEST);

        societyManager.addToSociety(user,societyManager.getSocietyByID(soc_id));

        return ok(true);
    }




}
