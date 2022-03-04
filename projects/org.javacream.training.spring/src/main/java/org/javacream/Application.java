package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		System.out.println("starting application...");
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
		System.out.println("application running!");
	}

	
}
