package com.koby5i.approvesvc.services;

//import org.springframework.cloud.netflix.feign.FeignClient;
import com.koby5i.approvesvc.domains.dto.OrderDto;
import com.koby5i.approvesvc.domains.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(name = "apiClient", url = "http://localhost:8081")
public interface FeignClientInterface {

    @GetMapping(path = "/api/orders", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<OrderDto> getOrders();


    @GetMapping(path = "/api/orderById/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    OrderDto getOrderById(@PathVariable("id") String id);


    @GetMapping(path = "/api/products", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<ProductDto> getProducts();

    @GetMapping(path = "/api/productById/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ProductDto getProductById(@PathVariable("id") String id);



}
