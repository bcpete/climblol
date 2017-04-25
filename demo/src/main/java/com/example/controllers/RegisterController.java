package com.example.controllers;

import com.example.models.Role;
import com.example.models.User;
import com.example.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
