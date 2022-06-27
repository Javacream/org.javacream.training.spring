package org.javacream;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.warehouse.api.Book;
import org.javacream.store.impl.MapStoreService.StoreKey;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdConfiguration {

	@Bean
	@Qualifier("books")
	public Map<String, Book> books() {
		HashMap<String, Book> books = new HashMap<>();
		return books;
	}

	@Bean
	@Qualifier("stock")
	public Map<StoreKey, Integer> store() {

		HashMap<StoreKey, Integer> store = new HashMap<>();
		return store;

	}
}
