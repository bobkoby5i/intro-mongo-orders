package com.koby5i.approvesvc.services;

//import org.springframework.cloud.netflix.feign.FeignClient;
import com.koby5i.approvesvc.domains.dto.OrderDto;
import com.koby5i.approvesvc.domains.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "apiClient", url = "http://localhost:8081")
public interface FeignClientInterface {

    @GetMapping(path = "/api/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> getOrders();

    @GetMapping(path = "/api/orderById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    OrderDto getOrderById(@PathVariable("id") String id);

    @GetMapping(path = "/api/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> getProducts();

    @GetMapping(path = "/api/productById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ProductDto getProductById(@PathVariable("id") String id);

    @PutMapping(path = "/api/setOrderStatusApproved/{customerId}/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    String OrderApprovedById(@PathVariable("customerId") String customerId, @PathVariable("id") String id);

    @PutMapping(path = "/api/setOrderStatusNotApproved/{customerId}/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    String OrderNotApprovedById(@PathVariable("customerId") String customerId, @PathVariable("id") String id);


}
