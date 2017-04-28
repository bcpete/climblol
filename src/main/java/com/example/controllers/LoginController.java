package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Brady on 4/7/17.
 */
@Controller
@RequestMapping(value="login")
public class LoginController {

    @RequestMapping(value="", method = RequestMethod.GET)
    public String displayLoginForm(Model model){
        model.addAttribute("title", "Login");

        return "login";
    }

}
