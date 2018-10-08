package org.javacream;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	@Bean public BooksService booksService() {
		MapBooksService booksService = new MapBooksService();
		booksService.setIsbnGenerator(isbnGenerator());
		booksService.setStoreService(storeService());
		return booksService;
	}
	@Bean public IsbnGenerator isbnGenerator() {
		RandomIsbnGenerator isbnGenerator = new RandomIsbnGenerator();
		isbnGenerator.setPrefix("JAVA-ISBN");
		isbnGenerator.setCountryCode("-is");
		return isbnGenerator;
	}
	@Bean public StoreService storeService() {
		SimpleStoreService storeService = new SimpleStoreService();
		storeService.setStock(42);
		return storeService;
	}
}
