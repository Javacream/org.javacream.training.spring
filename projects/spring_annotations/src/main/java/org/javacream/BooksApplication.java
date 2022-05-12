package org.javacream;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.javacream.books.isbngenerator.impl.CounterIsbnGeneratorImpl;
import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorImpl;
import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Audited;
import org.javacream.store.impl.SimpleStoreServiceImpl;
import org.javacream.store.impl.decorator.AuditingStoreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class BooksApplication {

	@Bean
	@SequenceStrategy
	public IsbnGenerator sequenceIsbnGenerator() {
		CounterIsbnGeneratorImpl counterIsbnGenerator = new CounterIsbnGeneratorImpl();
		return counterIsbnGenerator;
	}

	@Bean
	@RandomStrategy
	public IsbnGenerator randomStrategyIsbnGenerator(RandomIsbnGeneratorImpl rg) {
		return rg;
	}

	@Bean
	@Audited
	public StoreService storeService(SimpleStoreServiceImpl simpleStoreService) {
		AuditingStoreService auditingStoreService = new AuditingStoreService();
		auditingStoreService.setDelegate(simpleStoreService);
		return auditingStoreService;
	}

	
	@Bean @Profile("prod") @Qualifier("booksData") public Map<String, Book> booksData(){
		return new HashMap<>();
	}
	@Bean @Profile("prod") @Qualifier("orderData") public Map<Long, Order> orderData(){
		return new HashMap<>();
	}
	
}
