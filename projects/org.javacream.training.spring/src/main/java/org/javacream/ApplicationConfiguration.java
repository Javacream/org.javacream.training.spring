package org.javacream;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.decorator.BooksServiceDecorator;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.decorators.AuditingStoreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ApplicationConfiguration {

	@Bean
	@Qualifier("booksMap")
	public Map<String, Book> booksMap() {
		HashMap<String, Book> data = new HashMap<>();
		return data;
	}

	@Bean
	@Qualifier("ordersMap")
	public Map<Long, Order> ordersMap() {
		HashMap<Long, Order> data = new HashMap<>();
		return data;
	}

	@Bean
	@Primary
	public StoreService createStoreService() {
		AuditingStoreService auditingStoreService = new AuditingStoreService();
		return auditingStoreService;
	}

	@Bean
	@Primary
	public BooksService createBooksService() {
		BooksServiceDecorator decorator = new BooksServiceDecorator();
		return decorator;
	}

}
