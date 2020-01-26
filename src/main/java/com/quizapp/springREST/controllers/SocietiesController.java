package com.quizapp.springREST.controllers;

import com.quizapp.springREST.Model.Society;
import com.quizapp.springREST.Model.User;
import com.quizapp.springREST.Repositories.UserRepository;
import com.quizapp.springREST.services.SocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.openmbean.InvalidKeyException;
import java.util.List;

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
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        for (User x :
                newSociety.getUsers()) {
            System.out.println(x.getEmail());

        }
        societyManager.saveSociety(new Society(name));
    }

    @GetMapping("/getUserSocieties")
    public List<Society> getUserSocieties(@RequestParam String login)
    {
        return societyManager.getAllSocietesRelatedToUser(userRepository.findByEmail(login));
    }

    @PostMapping("/leaveSociety")
    public void LeaveSociety(@RequestParam String soc_id,@RequestParam String user_id)
    {
        societyManager.leaveSociety(userRepository.findById(user_id).get(),societyManager.getSocietyByID(soc_id));

    }



}
