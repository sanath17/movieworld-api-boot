package com.movieworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		 System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME,
//		 "prod");
		SpringApplication.run(Application.class, args);
	}
}