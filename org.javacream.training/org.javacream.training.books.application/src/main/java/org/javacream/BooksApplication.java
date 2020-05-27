package org.javacream;

import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {
		System.out.println("starting BooksApplication...");
		SpringApplication application = new SpringApplication(BooksApplication.class);
		application.setAdditionalProfiles("prod");
		application.run(args);
		System.out.println("finished BooksApplication");
	}
}
