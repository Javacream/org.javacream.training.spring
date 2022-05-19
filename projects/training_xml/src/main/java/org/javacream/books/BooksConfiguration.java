package org.javacream.books;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.javacream.util.profile.Production;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BooksConfiguration {

	@Production @Bean @Qualifier("booksData") public Map<String, Book> booksMap(){
		HashMap<String, Book> books = new HashMap<>();
		return books;
	}

	@Production @Bean @Qualifier("ordersData") public Map<Long, Order> ordersMap(){
		HashMap<Long, Order> orders= new HashMap<>();
		return orders;
	}
	
}
