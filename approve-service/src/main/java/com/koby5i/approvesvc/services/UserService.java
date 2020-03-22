package com.koby5i.approvesvc.services;

import com.koby5i.approvesvc.domains.User;


import java.util.List;


public interface UserService {

    List<User> listAll();

    User getById(String id);

    User saveOrUpdate(User user);

    void delete(String id);

    User getByUsername(String name);

//    Product saveOrUpdateProductForm(ProductForm productForm);
}
