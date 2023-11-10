package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.user"})
public class SpringBootRestApiApplicationForUserDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplicationForUserDataApplication.class, args);
	}
}
