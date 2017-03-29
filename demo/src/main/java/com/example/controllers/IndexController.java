package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Brady on 3/29/17.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "")
    public String index() {

        return "redirect:/home";
    }

}