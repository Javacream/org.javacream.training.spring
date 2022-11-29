package org.javacream;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.warehouse.api.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod") 
public class ApplicationConfiguration {

	@Bean public Map<String, Book> booksProd(){
		HashMap<String, Book> books =  new HashMap<>();
		return books;
	}

	
}
