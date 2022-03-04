package org.javacream;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationConfiguration {

	
	@Bean @Qualifier("booksMap")  
	//@Scope("prototype") @Qualifier("booksMap") 
	public Map<String, Book> booksMap(){
		HashMap<String, Book> data = new HashMap<>();
		return data;
	}
	@Bean @Qualifier("ordersMap")  
	//@Scope("prototype") @Qualifier("booksMap") 
	public Map<Long, Order> ordersMap(){
		HashMap<Long, Order> data = new HashMap<>();
		return data;
	}
	
}
