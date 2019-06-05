package org.javacream;

import javax.annotation.PostConstruct;

import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {
	
	@Autowired BooksService bs;
	
	@PostConstruct public void init() {
		System.out.println("bs: " + bs);
	}
	@Bean public StoreService storeService() {
		SimpleStoreService service = new SimpleStoreService();
		service.setStock(4711);
		return service;
	}
}