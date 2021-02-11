package org.javacream;

import javax.annotation.PostConstruct;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
}
