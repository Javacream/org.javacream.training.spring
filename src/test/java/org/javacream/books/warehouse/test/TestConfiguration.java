package org.javacream.books.warehouse.test;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.warehouse.api.Book;
import org.javacream.util.profiles.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Eine Configuration macht Dependency Outjection (kein Standard Begriff)
 */
@Configuration
@Test
public class TestConfiguration {

//	@Bean public Book book() {
//		Book book = new Book();
//		book.setIsbn("ISBN-OUT");
//		book.setTitle(("Outjected"));
//		return book;
//	}
	
	@Bean public Map<String, Book> books(){
		//ToDo: Test-Daten hinzufügen
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
