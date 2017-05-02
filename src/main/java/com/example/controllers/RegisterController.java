package com.example.controllers;

import com.example.models.*;
import com.example.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Brady on 4/7/17.
 * Handles requests to /register. First I create all of my DataAccessObject's, I have one for each class because I am going
 * to be creating a new user. displayRegisterForm responds to a get request with the form for registering a new user.
 * model.addAttribute passes all of the needed data into the Thymeleaf template.
 */
@Controller
@RequestMapping(value="register")
public class RegisterController {

    @Autowired
    private UserTypeDao userTypeDao;
    @Autowired
    private ServerDao serverDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserRankDao userRankDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private MainChampDao mainChampDao;

    @RequestMapping(value="", method = RequestMethod.GET)
    public String displayRegisterForm(Model model){
        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        model.addAttribute("types", userTypeDao.findAll());
        model.addAttribute("servers", serverDao.findAll());
        model.addAttribute("roles", roleDao.findAll());
        model.addAttribute("userranks", userRankDao.findAll());
        model.addAttribute("mainchamps", mainChampDao.findAll());

        return "register";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String processRegisterForm(Model model, @ModelAttribute @Valid User newUser,
                                      Errors errors, @RequestParam int roleId, @RequestParam int userRankId,
                                      @RequestParam int serverId, @RequestParam int userTypeId,
                                      @RequestParam(value="mainChampId") List<Integer> champArray){
        if(userDao.findByUsernameIgnoreCase(newUser.getUsername())!=null){
            model.addAttribute("userused", "Username is already taken");
            model.addAttribute("title", "Register");
            model.addAttribute("title","Register");
            model.addAttribute("types", userTypeDao.findAll());
            model.addAttribute("servers", serverDao.findAll());
            model.addAttribute("roles", roleDao.findAll());
            model.addAttribute("userranks", userRankDao.findAll());
            model.addAttribute("mainchamps", mainChampDao.findAll());
            return"register";
        }else if(errors.hasErrors()){
            model.addAttribute("title","Register");
            model.addAttribute("types", userTypeDao.findAll());
            model.addAttribute("servers", serverDao.findAll());
            model.addAttribute("roles", roleDao.findAll());
            model.addAttribute("userranks", userRankDao.findAll());
            model.addAttribute("mainchamps", mainChampDao.findAll());
            return"register";
        }
        Role newRole =roleDao.findOne(roleId);
        newRole.addUser(newUser);
        UserRank newRank = userRankDao.findOne(userRankId);
        newRank.addUser(newUser);
        Server newServer = serverDao.findOne(serverId);
        newServer.addUser(newUser);
        UserType newType = userTypeDao.findOne(userTypeId);
        newType.addUser(newUser);

        newUser.setRole(newRole);
        newUser.setUserRank(newRank);
        newUser.setServer(newServer);
        newUser.setUserType(newType);

        for(int i = 0; i<champArray.size(); i++){
            MainChamp newChamp = mainChampDao.findOne(champArray.get(i));
            newChamp.addUser(newUser);
        }
        userDao.save(newUser);


        return "redirect:/" + newUser.getUsername();
    }
}
