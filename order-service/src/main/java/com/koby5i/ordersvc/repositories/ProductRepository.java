package com.koby5i.ordersvc.repositories;

import com.koby5i.ordersvc.domains.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findByNumber(String number);
    List<Product> findByNumberIn(Collection<String> ids); //TODO how to use it
    List<Product> findByCategory(final String category);
}
