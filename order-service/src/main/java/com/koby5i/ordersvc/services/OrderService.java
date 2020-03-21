package com.koby5i.ordersvc.services;

import com.koby5i.ordersvc.domains.Order;


import java.util.List;


public interface OrderService {

    List<Order> listAll();

    Order getById(String id);

    Order saveOrUpdate(Order order);

    void delete(String id);

//    Product saveOrUpdateProductForm(ProductForm productForm);
}
