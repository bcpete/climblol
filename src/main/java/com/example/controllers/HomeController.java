package com.example.controllers;

import com.example.models.User;
import com.example.models.UserType;
import com.example.models.data.UserDao;
import com.example.models.data.UserTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

/**
 * Created by Brady on 3/29/17.
 */
@Controller
@RequestMapping(value="home")
public class HomeController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserTypeDao userTypeDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(Model model) {

        Random r = new Random();
        int Low = 3000;
        int High = 5555;
        int Result = r.nextInt(High-Low) + Low;

        UserType coach = userTypeDao.findOne(1);
        UserType student= userTypeDao.findOne(2);

        List<User> students = userDao.findByuserType(student);
        List<User> coaches = userDao.findByuserType(coach);

        model.addAttribute("numberofcoaches", coaches);
        model.addAttribute("numberofstudents", students);
        model.addAttribute("elos", Result);
        model.addAttribute("title", "ClimbLol.com");
        return "home";
    }
}
