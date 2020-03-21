package com.koby5i.ordersvc.controllers;

import com.koby5i.ordersvc.domains.Product;
import com.koby5i.ordersvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/api/products", method = RequestMethod.GET)
    public Iterable<Product> getAllProducts(){
        System.out.println("GET /api/products");
        return productService.listAll();
    }

    @RequestMapping(value = "/api/productById/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String id){
        System.out.println("GET /api/product/{id} id=" + id);
        Product product = productService.getById(id);
        return product;
    }

}
