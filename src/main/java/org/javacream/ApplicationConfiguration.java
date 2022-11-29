package org.javacream;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfiguration {

	@Bean @Profile("test") public Map<String, Book> booksTest(){
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
	@Bean @Profile("prod") public Map<String, Book> booksProd(){
		HashMap<String, Book> books =  new HashMap<>();
		return books;
	}

	
	@Bean @RandomStrategy public IsbnGenerator random(@Value("${isbngenerator.prefix}") String prefix, @Value("${isbngenerator.countryCode}") String countryCode) {
		RandomIsbnGenerator rig = new RandomIsbnGenerator();
		rig.setPrefix(prefix);
		rig.setCountryCode(countryCode);
		return rig;
	}
	
}
