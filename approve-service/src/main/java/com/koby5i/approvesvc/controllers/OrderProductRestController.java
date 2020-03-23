package com.koby5i.approvesvc.controllers;

import com.koby5i.approvesvc.domains.User;
import com.koby5i.approvesvc.services.FeignClientInterface;
import com.koby5i.approvesvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class OrderProductRestController {

    private UserService userService;

    @Autowired
    private FeignClientInterface feignClientInterface;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }



    public void setWhClient(FeignClientInterface feignClientInterface) {
        this.feignClientInterface = feignClientInterface;
    }

    public OrderProductRestController(FeignClientInterface feignClientInterface) {
        this.feignClientInterface = feignClientInterface;
    }


    @RequestMapping(value = "/getProductById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductById(@PathVariable("id") String id){
        return new ResponseEntity<>(feignClientInterface.getProductById(id), HttpStatus.OK);

    }

    @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
    public ResponseEntity<?> getProducts(){
        return new ResponseEntity<>(feignClientInterface.getProducts(), HttpStatus.OK);

    }

    @RequestMapping(value = "/getOrderById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrderById(@PathVariable("id") String id){
        return new ResponseEntity<>(feignClientInterface.getOrderById(id), HttpStatus.OK);

    }

    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    public ResponseEntity<?> getOrders(){
        return new ResponseEntity<>(feignClientInterface.getOrders(), HttpStatus.OK);

    }

    @RequestMapping(value = "/user/getProductById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> userGetProductById(@PathVariable("id") String id){
        return new ResponseEntity<>(feignClientInterface.getProductById(id), HttpStatus.OK);

    }

    @RequestMapping(value = "/user/getProducts", method = RequestMethod.GET)
    public ResponseEntity<?> userGetProducts(){
        return new ResponseEntity<>(feignClientInterface.getProducts(), HttpStatus.OK);

    }

    @RequestMapping(value = "/user/getOrderById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> userGetOrderById(@PathVariable("id") String id){
        return new ResponseEntity<>(feignClientInterface.getOrderById(id), HttpStatus.OK);

    }

    @RequestMapping(value = "/user/getOrders", method = RequestMethod.GET)
    public ResponseEntity<?> userGetOrders(){
        return new ResponseEntity<>(feignClientInterface.getOrders(), HttpStatus.OK);

    }

    @RequestMapping(value = "/user/orderApproved/{id}", method = RequestMethod.GET)
    public String userOrderApprovedById(@PathVariable("id") String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication instanceof AnonymousAuthenticationToken)) {
            return "Sorry, currentUserName can not be determined. User not authenticated yet. Go to /user to login";
        }

        String currentUserName = authentication.getName();
        User user = userService.getByUsername(currentUserName);
        String customerId = user.getCustomerId();
        System.out.printf("/user/orderApproved/{%s} by customerId: %s username: %s %n ", id , customerId, currentUserName);
        String response = feignClientInterface.OrderApprovedById(customerId, id);

        return response;

    }

    @RequestMapping(value = "/user/orderNotApproved/{id}", method = RequestMethod.GET)
    public String userOrderNotApprovedById(@PathVariable("id") String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication instanceof AnonymousAuthenticationToken)) {
            return "Sorry, currentUserName can not be determined. User not authenticated yet. Go to /user to login";
        }

        String currentUserName = authentication.getName();
        User user = userService.getByUsername(currentUserName);
        String customerId = user.getCustomerId();
        System.out.printf("/user/orderApproved/{%s} by customerId: %s username: %s %n ", id , customerId, currentUserName);
        String response = feignClientInterface.OrderNotApprovedById(customerId, id);

        return response;

    }


}


