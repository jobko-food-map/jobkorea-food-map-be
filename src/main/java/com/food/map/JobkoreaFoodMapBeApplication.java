package com.food.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
public class JobkoreaFoodMapBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobkoreaFoodMapBeApplication.class, args);
	}

}
