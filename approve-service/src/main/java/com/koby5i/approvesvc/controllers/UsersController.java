package com.koby5i.approvesvc.controllers;

import com.koby5i.approvesvc.domains.User;
import com.koby5i.approvesvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsersController {

    private UserService userService;

    @Autowired
    public void setItemService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/api/hello", method = RequestMethod.GET)
    public String RestApiHello(){
        return "Hello from RESTController";
    }

    @RequestMapping(value = "/api/showUsers", method = RequestMethod.GET)
    public Iterable<User> showUsers(){
        System.out.println("GET /api/products");
        return userService.listAll();
    }
}
