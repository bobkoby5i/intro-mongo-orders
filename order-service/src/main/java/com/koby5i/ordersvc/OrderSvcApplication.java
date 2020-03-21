package com.koby5i.ordersvc;

import com.koby5i.ordersvc.domains.Product;
import com.koby5i.ordersvc.repositories.ProductRepository;
import com.koby5i.ordersvc.services.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;
import java.util.Optional;

@SpringBootApplication
// needed because the repository is not in the same package or a sub package of the SpringBootApplication
@EnableMongoRepositories(basePackageClasses = ProductRepository.class)
public class OrderSvcApplication {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	DataLoader dataLoader;

	public static void main(String[] args) {
		SpringApplication.run(OrderSvcApplication.class, args);
		System.out.println("Hello World from OrderSvcApplication");
	}

	@PostConstruct
	void showProducts() {
		System.out.println("showproducts method called ...");
		for(Product product : productRepository.findAll()){
			System.out.println("product shortname" + product.getShortName());
		}
		System.out.println("Find by number(C02)");
		Optional<Product> car = productRepository.findByNumber("C02");
		if(car.isPresent()){
//		System.out.println("product shortname" + car.getShortName());
			System.out.println("found !");
		}


		System.out.println("Find by category (Cars)");
		//productRepository.findByCategory("Cars").forEach(System.out::println);
		for(Product product : productRepository.findByCategory("Cars")){
			System.out.printf("product category: %s shortname: %s%n" ,product.getCategory(),  product.getShortName());
		}

		//address.setCountry("US");
		//personRepository.save(john);
		//System.out.println("Find by country (US)");
		//personRepository.findByCountry("US").forEach(System.out::println);
	}

}
