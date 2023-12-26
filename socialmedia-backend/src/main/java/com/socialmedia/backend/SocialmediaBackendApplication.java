package com.socialmedia.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.socialmedia.backend.Repository")

public class SocialmediaBackendApplication {


	public static void main(String[] args) {
		SpringApplication.run(SocialmediaBackendApplication.class, args);
	}

}
