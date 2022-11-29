package org.javacream;

import javax.annotation.PostConstruct;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfiguration {
	
	// @Value("${messagePrefix}") private String messagePrefix;
	@PostConstruct
	public void init() {
		System.out.println("############ init " + this);
	}

	@Bean @Scope("singleton") public String message() {
		System.out.println("###########################");
		return "Hello World";
	}
//	@Bean public String message(@Value("${messagePrefix}") String messagePrefix, @RandomStrategy IsbnGenerator ig) {
//		return messagePrefix +  " World " + ig.next(); 
//	}

	@Bean @RandomStrategy public IsbnGenerator random(@Value("${isbngenerator.prefix}") String prefix, @Value("${isbngenerator.countryCode}") String countryCode) {
		RandomIsbnGenerator rig = new RandomIsbnGenerator();
		rig.setPrefix(prefix);
		rig.setCountryCode(countryCode);
		message();
		message();
		message();
		return rig;
	}
	
}
