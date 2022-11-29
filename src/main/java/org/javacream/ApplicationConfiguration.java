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
@Profile("prod") 
public class ApplicationConfiguration {

	@Bean public Map<String, Book> booksProd(){
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
