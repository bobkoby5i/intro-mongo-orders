package com.koby5i.approvesvc.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value="/greeting", method = RequestMethod.GET)
    public String greeting() {
        return "greeting.html";
    }


    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/admin/index", method = RequestMethod.GET)
    public String adminIndex() {
        return "/admin/padmin.html";
    }
}
