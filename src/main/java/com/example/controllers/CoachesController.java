package com.example.controllers;

import com.example.models.UserType;
import com.example.models.data.UserDao;
import com.example.models.data.UserTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Brady on 5/1/17.
 * Handles all requests to /coaches. First I create the two DataAccessObjects's to access the database.
 * Then I find a UserType object with the id for a coach in the database. Then I query the database using a
 * findByuserType method, passing the retrieved coach UserType object as a parameter to retrieve all of the
 * users with a UserType of "coach" and a UserType id of "1". Then pass all of the relevant data into the
 * Thymeleaf template "coaches.html".
 */

@Controller
@RequestMapping("coaches")
public class CoachesController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeDao userTypeDao;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listCoachesPage(Model model){
        UserType coach = userTypeDao.findOne(1);
        model.addAttribute("coaches", userDao.findByuserType(coach));
        model.addAttribute("title", "Coaches");
        return "coaches";
    }
}
