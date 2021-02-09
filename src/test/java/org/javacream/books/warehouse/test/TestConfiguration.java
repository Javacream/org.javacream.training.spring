package org.javacream.books.warehouse.test;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.warehouse.api.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
 * Eine Configuration macht Dependency Outjection (kein Standard Begriff)
 */
@Configuration
@Profile("test")
public class TestConfiguration {

	
	@Bean public Map<String, Book> books(){
		HashMap<String, Book> data = new HashMap<>();
		Book b1 = new Book();
		b1.setIsbn("TEST-ISBN1");
		b1.setTitle("TEST-TITLE1");
		Book b2 = new Book();
		b2.setIsbn("TEST-ISBN2");
		b2.setTitle("TEST-TITLE2");
		data.put(b1.getIsbn(), b1);
		data.put(b2.getIsbn(), b2);
		return data;
	}
	
}
