package org.javacream;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SimpleRandomStrategy;
import org.javacream.books.isbngenerator.impl.MathRandomIsbnGenerator;
import org.javacream.books.warehouse.api.Book;
import org.javacream.store.api.StoreService;
import org.javacream.store.decorators.AuditingStoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.util.profiles.Prod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Eine Configuration macht Dependency Outjection (kein Standard Begriff)
 */
@Configuration
@Prod
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
	public IsbnGenerator simpleIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix,
			@Value("${isbngenerator.countryCode}") String countryCode

	) {
		MathRandomIsbnGenerator isbnGenerator = new MathRandomIsbnGenerator();
		isbnGenerator.setPrefix(prefix);
		isbnGenerator.setCountryCode(countryCode);
		return isbnGenerator;
	}

	
}
