package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration 
public class OuterStoreServiceTestConfiguration{
	@Value("${defaultStock}") private int stock;
	
	@Bean public StoreService storeService() {
		SimpleStoreService simpleStoreService = new SimpleStoreService();
		simpleStoreService.setStock(stock);
		return simpleStoreService;
	}
}