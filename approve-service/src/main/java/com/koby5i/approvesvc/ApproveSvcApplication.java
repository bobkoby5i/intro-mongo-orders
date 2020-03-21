package com.koby5i.approvesvc;

import com.koby5i.approvesvc.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class ApproveSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApproveSvcApplication.class, args);
	}

}
