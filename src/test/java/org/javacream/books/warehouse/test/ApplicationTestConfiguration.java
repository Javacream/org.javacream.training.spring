package org.javacream.books.warehouse.test;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.warehouse.api.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ApplicationTestConfiguration {

	@Bean  public Map<String, Book> booksTest(){
		HashMap<String, Book> books =  new HashMap<>();
		Book b1 = new Book();
		b1.setIsbn("ISBN-1001");
		b1.setTitle("Test 1");
		b1.setPrice(19.99);
		books.put(b1.getIsbn(), b1);

		Book b2 = new Book();
		b2.setIsbn("ISBN-1002");
		b2.setTitle("Test 2");
		b2.setPrice(9.99);
		books.put(b2.getIsbn(), b2);

		return books;
	}
	
	
}
