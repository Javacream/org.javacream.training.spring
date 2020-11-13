package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.store.impl.decorator.AuditingStoreService;
import org.javacream.store.impl.decorator.CountingStoreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.javacream.store", "org.javacream.util"})
public class StoreServiceConfiguration {
	@Bean @Qualifier("forBooksService") public StoreService forBooksService(SimpleStoreService simpleStoreService, CountingStoreService countingStoreService) {
		countingStoreService.setStoreService(simpleStoreService);
		return countingStoreService;

	}
	@Bean @Qualifier("forTest") public StoreService storeService(SimpleStoreService simpleStoreService, AuditingStoreService auditingStoreService) {
		auditingStoreService.setStoreService(simpleStoreService);
		return auditingStoreService;

	}
}