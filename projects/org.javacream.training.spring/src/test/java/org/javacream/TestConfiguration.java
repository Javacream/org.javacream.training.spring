package org.javacream;

import java.util.HashMap;
import java.util.Map;

import org.javacream.books.order.api.Order;
import org.javacream.books.warehouse.api.Book;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.decorators.AuditingStoreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {

	
	@Bean @Qualifier("booksMap")  
	//@Scope("prototype") @Qualifier("booksMap") 
	public Map<String, Book> booksMap(){
		HashMap<String, Book> data = new HashMap<>();
		//TODO: add test data
		return data;
	}
	@Bean @Qualifier("ordersMap")  
	//@Scope("prototype") @Qualifier("booksMap") 
	public Map<Long, Order> ordersMap(){
		HashMap<Long, Order> data = new HashMap<>();
		//TODO: add test data
		return data;
	}
	
	@Bean @Primary public StoreService createStoreService() {
		AuditingStoreService auditingStoreService = new AuditingStoreService();
		return auditingStoreService;
	}//Auflösen des @Autowired, @Value, @PostConstruct
	
	
}
