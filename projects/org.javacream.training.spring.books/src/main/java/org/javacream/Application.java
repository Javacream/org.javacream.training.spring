package org.javacream;

import org.javacream.books.warehouse.api.BooksService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.setAdditionalProfiles("prod");
		ConfigurableApplicationContext context = springApplication.run(args);
		BooksService bs = context.getBean(BooksService.class);
		System.out.println("H E L L O");
	}

}
