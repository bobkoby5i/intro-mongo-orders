package com.koby5i.ordersvc.controllers;

import com.koby5i.ordersvc.domains.Order;
import com.koby5i.ordersvc.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {
    private OrderService orderService;

    @Autowired
    public void setLabService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/api/orders", method = RequestMethod.GET)
    public Iterable<Order> getAllOrders(){
        System.out.println("GET /api/orders from: ");
        return orderService.listAll();
    }


    @RequestMapping(value = "/api/orderById/{id}", method = RequestMethod.GET)
    public Order getLab(@PathVariable String id){
        System.out.println("GET /api/orderById/{id} id=" + id);

        Order order = orderService.getById(id);
        //product.getId().toHexString()
        //System.out.println("Fetch Order Id: " + order.getId());
        //System.out.println("Fetch Lab Id: " + product.getId().toHexString());
        return order;
    }

}
