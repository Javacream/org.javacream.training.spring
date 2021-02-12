package org.javacream;

import javax.annotation.PostConstruct;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication //beinhaltet @Configuration
public class BooksApplication {

	@Autowired private BooksService booksService;
	@Autowired @SequenceStrategy private IsbnGenerator isbnGenerator;
	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
		System.out.println("Application started!");
	}
	
	@PostConstruct public void startUp() {
		System.out.println("booksService = " + booksService);
		System.out.println(isbnGenerator.next());
	}
	
	@Bean @Qualifier("store") RestTemplate restTemplateForStore(RestTemplateBuilder rtb) {
		return rtb.build();
	}
}
