package com.koby5i.ordersvc.services;

import com.koby5i.ordersvc.domains.Product;



import java.util.List;


public interface ProductService {

    List<Product> listAll();

    Product getById(String id);

    Product saveOrUpdate(Product product);

    void delete(String id);

//    Product saveOrUpdateProductForm(ProductForm productForm);
}
