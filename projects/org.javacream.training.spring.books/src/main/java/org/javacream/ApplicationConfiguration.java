package org.javacream;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.DatabaseStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ApplicationConfiguration {
	
	@Bean public StoreService storeService() {
		DatabaseStoreService service = new DatabaseStoreService();
		return service;
	}
}
