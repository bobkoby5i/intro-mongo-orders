package com.koby5i.ordersvc.services;


import com.koby5i.ordersvc.domains.Order;
import com.koby5i.ordersvc.domains.Product;
import com.koby5i.ordersvc.repositories.OrderRepository;
import com.koby5i.ordersvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
