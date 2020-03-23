package com.koby5i.approvesvc.controllers;

import com.koby5i.approvesvc.domains.User;
import com.koby5i.approvesvc.repositories.UserRepository;
import com.koby5i.approvesvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

@Controller
public class UsersController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName4(HttpServletRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();

            User user = userService.getByUsername(currentUserName);
            String customerId = user.getCustomerId();
            String message= "principal.username: " + currentUserName + " user.customerId: " + customerId;

            return message;
        }
        return "Sorry, currentUserName can not be determined. User not authenticated yet. Go to /user to login";
    }

    @RequestMapping(value = "/username2", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName1(Authentication authentication) {
        return authentication.getName();
    }


    @RequestMapping(value = "/username3", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName13(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }



    @RequestMapping(value = "/username4", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName4(Principal principal) {

        String username = principal.getName();
        User user = userService.getByUsername(username);
        String customerId = user.getCustomerId();
        String message= "principal.username: " + username + " user.customerId: " + customerId;
        return message;
    }


}
