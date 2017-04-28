package com.example.controllers;

import com.example.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Brady on 4/27/17.
 */
@Controller
@RequestMapping("users")

public class UsersController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listUserPage(Model model){
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "User List");
        return "users";
    }
}
