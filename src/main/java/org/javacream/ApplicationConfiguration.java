package org.javacream;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.SimpleRandomStrategy;
import org.javacream.books.isbngenerator.impl.MathRandomIsbnGeneratorService;
import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
 * Eine Configuration macht Dependency Outjection (kein Standard Begriff)
 */
@Configuration
@Profile("prod")
public class ApplicationConfiguration {

	/*
	 * @Value("${isbngenerator.prefix}") private String prefix;
	 * 
	 * @Value("${isbngenerator.countryCode}") private String countryCode;
	 */
//	@Bean public Book book() {
//		Book book = new Book();
//		book.setIsbn("ISBN-OUT");
//		book.setTitle(("Outjected"));
//		return book;
//	}

	@Bean
	public Map<String, Book> books() {
		return new HashMap<>();
	}

	@Bean
	@SimpleRandomStrategy
	public IsbnGeneratorService simpleIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix,
			@Value("${isbngenerator.countryCode}") String countryCode

	) {
		MathRandomIsbnGeneratorService isbnGenerator = new MathRandomIsbnGeneratorService();
		isbnGenerator.setPrefix(prefix);
		isbnGenerator.setCountryCode(countryCode);
		return isbnGenerator;
	}

	
}
