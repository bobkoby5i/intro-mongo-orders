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

    @RequestMapping(value = "/api/setOrderStatusApproved/{customerId}/{id}", method = RequestMethod.PUT)
    public String setOrderStatusApproved(@PathVariable String customerId, @PathVariable String id){
        System.out.println("GET /api/setOrderStatusApproved/{customerId}/{id} id=" + id);

        String response = orderService.updateOrderStatus(id, customerId, "feignClient", Order.Status.APPROVED);

        return response;
    }

    @RequestMapping(value = "/api/setOrderStatusNotApproved/{customerId}/{id}", method = RequestMethod.PUT)
    public String setOrderStatusNotApproved(@PathVariable String customerId, @PathVariable String id){
        System.out.println("GET /api/setOrderStatusNotApproved/{customerId}/{id} id=" + id);

        String response = orderService.updateOrderStatus(id, customerId, "feignClient", Order.Status.NOT_APPROVED);

        return response;
    }


}
