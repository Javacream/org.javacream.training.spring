package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.DatabaseStoreService;
import org.javacream.store.impl.decorator.AuditingStoreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.javacream.store", "org.javacream.util"})
public class StoreServiceConfiguration {
	@Bean @Qualifier("actor1") public StoreService forActor1(DatabaseStoreService simpleStoreService) {
		return simpleStoreService;
		
	}
	@Bean @Qualifier("actor2") public StoreService forActor2(DatabaseStoreService simpleStoreService, AuditingStoreService auditingStoreService) {
		auditingStoreService.setStoreService(simpleStoreService);
		return auditingStoreService;
		
	}
}
