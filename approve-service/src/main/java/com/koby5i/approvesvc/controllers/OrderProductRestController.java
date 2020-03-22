package com.koby5i.approvesvc.controllers;

import com.koby5i.approvesvc.services.FeignClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class OrderProductRestController {

    @Autowired
    private FeignClientInterface feignClientInterface;

    public void setWhClient(FeignClientInterface feignClientInterface) {
        this.feignClientInterface = feignClientInterface;
    }

    public OrderProductRestController(FeignClientInterface feignClientInterface) {
        this.feignClientInterface = feignClientInterface;
    }


    @RequestMapping(value = "/getProductBy/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductById(@PathVariable("id") String id){
        return new ResponseEntity<>(feignClientInterface.getProductById(id), HttpStatus.OK);

    }

    @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
    public ResponseEntity<?> getItems(){
        return new ResponseEntity<>(feignClientInterface.getProducts(), HttpStatus.OK);

    }


}
