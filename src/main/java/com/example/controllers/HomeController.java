package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Brady on 3/29/17.
 */
@Controller
@RequestMapping(value="home")
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("title", "ClimbLol.com");
        return "home";
    }
}
