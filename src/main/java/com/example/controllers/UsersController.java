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
 * Created by Brady on 4/27/17.
 *  * Handles all requests to /users. First I create the two DataAccessObjects's to access the database.
 * Then I find a UserType object with the id for a student in the database. Then I query the database using a
 * findByuserType method, passing the retrieved student UserType object as a parameter to retrieve all of the
 * users with a UserType of "student" and a UserType id of "2". Then pass all of the relevant data into the
 * Thymeleaf template "users.html".
 */
@Controller
@RequestMapping("users")

public class UsersController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeDao userTypeDao;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listUserPage(Model model){
        UserType student = userTypeDao.findOne(2);
        model.addAttribute("users", userDao.findByuserType(student));
        model.addAttribute("title", "Duos");
        return "users";
    }
}
