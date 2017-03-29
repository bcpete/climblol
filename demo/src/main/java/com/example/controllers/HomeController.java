package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Brady on 3/29/17.
 */
@Controller
@RequestMapping("home")
public class HomeController {

    @RequestMapping(value = "")
    public String home(Model model) {
        model.addAttribute("title", "ClimbLol.com");
        return "home";
    }
}
