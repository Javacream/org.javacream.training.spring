package org.javacream;

import javax.annotation.PostConstruct;

import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication {

	@Autowired private BooksService booksService;
	public static void main(String[] args) {
		System.out.println("starting BooksApplication...");
		SpringApplication.run(BooksApplication.class, args);
		System.out.println("finished BooksApplication");
	}
	
	@PostConstruct public void init() {
		try {
			String isbn = booksService.newBook("Spring");
			Book book = booksService.findBookByIsbn(isbn);
			System.out.println(book);
		} catch (BookException e) {
			e.printStackTrace();
		}
	}

}
