package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//Aggregat-Annotation, die z.B. ComponentScan, PropertySource ("application.properties")
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setAdditionalProfiles("prod");
		app.run(args);
		System.out.println("main application is running!");
	}
}
