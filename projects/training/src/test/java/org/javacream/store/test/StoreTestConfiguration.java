package org.javacream.store.test;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.store.impl.decorators.AuditingStoreService;
import org.javacream.util.profile.Development;
import org.javacream.util.profile.TestAndQs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Development @TestAndQs
public class StoreTestConfiguration {

	@Bean public StoreService storeService() {
		SimpleStoreService simpleStoreService = new org.javacream.store.impl.SimpleStoreService();
		simpleStoreService.setStock(42);
		simpleStoreService.initialize();

		AuditingStoreService auditingStoreService = new org.javacream.store.impl.decorators.AuditingStoreService();
		auditingStoreService.setDelegate(simpleStoreService);
		return auditingStoreService;
	}
}
