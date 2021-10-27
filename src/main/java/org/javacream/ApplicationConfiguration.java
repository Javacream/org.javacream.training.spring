package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//Aggregat-Annotation, die z.B. ComponentScan, PropertySource ("application.properties")
public class ApplicationConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfiguration.class, args);
		System.out.println("main application is running!");
	}
}
