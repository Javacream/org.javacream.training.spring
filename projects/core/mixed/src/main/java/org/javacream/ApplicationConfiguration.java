package org.javacream;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("org.javacream")
@ImportResource(locations="classpath:/bookswarehouse.xml")
public class ApplicationConfiguration {
	
	
	@Bean public StoreService storeService(@Value("${storeService.stock}") Integer stock) {
		SimpleStoreService storeService = new SimpleStoreService();
		storeService.setStock(stock);
		return storeService;
	}
}
