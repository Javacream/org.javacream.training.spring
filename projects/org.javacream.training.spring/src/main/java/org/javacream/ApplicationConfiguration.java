package org.javacream;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.warehouse.api.Book;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationConfiguration {

	
	@Bean 
	//@Scope("prototype") @Qualifier("booksMap") 
	public Map<String, Book> booksMap(){
		HashMap<String, Book> data = new HashMap<>();
		return data;
	}
//	
//	@Bean public String countryCode() {
//		return "-is";
//	}
	
}
