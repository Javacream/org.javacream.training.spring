package org.javacream;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class BooksApplication {

	@Bean
	@SequenceStrategy
	public IsbnGenerator sequenceIsbnGenerator() {
		CounterIsbnGenerator counterIsbnGenerator = new CounterIsbnGenerator();
		return counterIsbnGenerator;
	}

	@Bean
	@RandomStrategy
	public IsbnGenerator randomStrategyIsbnGenerator(RandomIsbnGenerator rg) {
		return rg;
	}
	
	@Bean @Profile("prod") @Qualifier("booksData") public Map<String, Book> booksData(){
		return new HashMap<>();
	}
	@Bean @Profile("prod") @Qualifier("orderData") public Map<Long, Order> orderData(){
		return new HashMap<>();
	}
	
}
