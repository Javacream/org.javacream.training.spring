package org.javacream.books.warehouse.test;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.warehouse.api.Book;
import org.javacream.store.impl.MapStoreService.StoreKey;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "org.javacream")
//@PropertySource("classpath:application.properties")
public class TestConfiguration {

	@Bean
	@Qualifier("books")
	public Map<String, Book> books() {
		HashMap<String, Book> books = new HashMap<>();
		books.put("ISBN1", new Book("ISBN1", "Title1", 19.99, false));
		books.put("ISBN2", new Book("ISBN2", "Title2", 1.99, false));
		books.put("ISBN3", new Book("ISBN3", "Title3", 9.99, true));
		books.put("ISBN4", new Book("ISBN4", "Title4", 99.99, false));
		return books;
	}

	@Bean
	@Qualifier("stock")
	public Map<StoreKey, Integer> store() {

		HashMap<StoreKey, Integer> store = new HashMap<>();
		store.put(new StoreKey("books", "ISBN1"), 42);
		store.put(new StoreKey("books", "ISBN2"), 4);
		store.put(new StoreKey("books", "ISBN3"), 2);
		store.put(new StoreKey("books", "ISBN4"), 2);
		return store;

	}
}
