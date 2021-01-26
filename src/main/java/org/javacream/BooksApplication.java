package org.javacream;

import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BooksApplication {

    @Autowired
	private BooksService booksService;
	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
		System.out.println("Books Application running!");

	}

	@PostConstruct public void init() throws Exception{
		System.out.println(booksService.newBook("Spring"));
	}
}
