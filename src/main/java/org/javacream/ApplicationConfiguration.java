package org.javacream;

import org.javacream.books.warehouse.api.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Eine Configuration macht Dependency Outjection (kein Standard Begriff)
 */
@Configuration
public class ApplicationConfiguration {

	@Bean public Book book() {
		Book book = new Book();
		book.setIsbn("ISBN-OUT");
		book.setTitle(("Outjected"));
		return book;
	}
	
}
