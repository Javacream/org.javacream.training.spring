package org.javacream.books;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BooksApplicationConfiguration {

	@Bean public BooksService booksService(IsbnGenerator isbnGenerator, StoreService storeService) {
		MapBooksService mapBooksService = new MapBooksService();
		mapBooksService.setIsbnGenerator(isbnGenerator);
		mapBooksService.setStoreService(storeService);
		return mapBooksService;
	}
}
