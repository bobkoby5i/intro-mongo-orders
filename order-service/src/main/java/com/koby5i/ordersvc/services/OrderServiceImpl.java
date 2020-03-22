package com.koby5i.ordersvc.services;


import com.koby5i.ordersvc.domains.Order;
import com.koby5i.ordersvc.domains.Product;
import com.koby5i.ordersvc.repositories.OrderRepository;
import com.koby5i.ordersvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> listAll() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add); //fun with Java 8
        return orders;
    }

    @Override
    public Order getById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order saveOrUpdate(Order order) {
        orderRepository.save(order);
        //ObjectId.get()
        return order;
    }

    @Override
    public void delete(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public String updateOrderStatus(String id, String customerId, String username, Order.Status newStatus) {
        Order order = orderRepository.findById(id).orElse(null);
        if( order == null ) {
            System.out.printf("ERROR: order %s not found%n", id);
            return "ERROR: order not found id:" + id;
        }

        if ( !customerId.equals(order.getCustomerId()) ) {
            System.out.printf("ERROR: order.customerId %s <> customerId %s %n", order.getCustomerId(), customerId);
            return "ERROR: CustomerId does not match order:" + order.getCustomerId() + " parameter "+ customerId ;
        }

        order.setUpdatedBy(username);
        order.setStatus(newStatus);
        order.setUpdatedAt(LocalDateTime.now());
        System.out.println("Updating order (id: " + order.getId() + ", number:" + order.getOrderNumber() + ") ...");
        orderRepository.save(order);
        return "Order Status changed to " + newStatus ;
    }
}



