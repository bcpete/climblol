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
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.example.controllers.helperFunctions.checkUserNameIsUsed;

/**
 * Created by Brady on 4/7/17.
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
        if(checkUserNameIsUsed(newUser.getUsername())){
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


        return "redirect:/profile/{username}";
    }
}
