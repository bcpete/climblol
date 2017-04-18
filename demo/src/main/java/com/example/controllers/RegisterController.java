package com.example.controllers;

import com.example.models.User;
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

    @RequestMapping(value="", method = RequestMethod.GET)
    public String displayRegisterForm(Model model){
        model.addAttribute(new User());
        model.addAttribute("title", "Register");

        return "register";
    }
}
