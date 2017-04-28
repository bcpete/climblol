package com.example.controllers;

import com.example.models.User;
import com.example.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Brady on 4/27/17.
 */
@Controller
@RequestMapping(value="{username}")
public class ProfileController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String viewProfile(Model model, @PathVariable("username")String username){

        User user = userDao.findByUsername(username);

        model.addAttribute(user);
        model.addAttribute("title", user.getUsername()+"'s Profile");
        return"profile";
    }
}
