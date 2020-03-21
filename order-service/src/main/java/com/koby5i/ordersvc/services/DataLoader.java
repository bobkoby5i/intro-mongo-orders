package com.koby5i.ordersvc.services;

import com.koby5i.ordersvc.domains.Address;
import com.koby5i.ordersvc.domains.Order;
import com.koby5i.ordersvc.domains.OrderLine;
import com.koby5i.ordersvc.domains.Product;
import com.koby5i.ordersvc.repositories.OrderRepository;
import com.koby5i.ordersvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class DataLoader {
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    @Autowired
    public DataLoader(ProductRepository productRepository, OrderRepository orderRepository){
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @PostConstruct
    private void loadData(){
        System.out.println("loadData()  ... ");
        System.out.println("deleteAll(orders)");
        System.out.println("deleteAll(products)");
        productRepository.deleteAll();
        orderRepository.deleteAll();


        final Product car01 = new Product("C01", "Cars", "volvo","PCS", "VOLVO XC90",1, LocalDateTime.now(),  LocalDateTime.now(), "DataLoader", "DataLoader");
        final Product car02 = new Product("C02", "Cars", "saab","PCS", "SAAB 95",1, LocalDateTime.now(),  LocalDateTime.now(), "DataLoader", "DataLoader");
        final Product car03 = new Product("C03", "Cars", "mitsubishi","PCS", "Mitsubishi Colt",1, LocalDateTime.now(),  LocalDateTime.now(), "DataLoader", "DataLoader");
        final Product car04 = new Product("C04", "Cars", "audi","PCS", "Audi A8",1, LocalDateTime.now(),  LocalDateTime.now(), "DataLoader", "DataLoader");
        final Product car05 = new Product("C05", "Cars", "bmw","PCS", "BMW X1",1, LocalDateTime.now(),  LocalDateTime.now(), "DataLoader", "DataLoader");
        final List<Product> products = Arrays.asList(car01, car02, car03, car04, car05);

        System.out.println("save(cars)");
        for (Product product :  products){
            System.out.printf("save(%s)%n", product.getDescription());
            productRepository.save(product);
        }

        final Address address = new Address("9320 Cliff Lodge Dr", "", "Snowbird", "UT", "United States", "84092", "+1 801-933-2222");

        final OrderLine ol1 = new OrderLine("C01","Cars", "volvo", "volvo xc 90", 10);
        final OrderLine ol2 = new OrderLine("C02","Cars", "saab", "saab 95", 15);
        final OrderLine ol3 = new OrderLine("C05","Cars", "bmw", "BMW X1", 12);

        final List<OrderLine> orderLines = Arrays.asList(ol1, ol2, ol3);

        final Order order = new Order("01", UUID.randomUUID().toString(), "Customer01", "Snowbird", address, LocalDateTime.now(), LocalDateTime.now(), "DataLoader", "DataLoader", orderLines, Order.Status.NEW);
        System.out.printf("saveOrder(%s)%n", order.getOrderNumber());
        orderRepository.save(order);

    }
}


