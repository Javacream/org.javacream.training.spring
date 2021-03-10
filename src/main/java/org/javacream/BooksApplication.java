package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BooksApplication.class);
		app.setAdditionalProfiles("prod");
		app.run(args);
	}

}
