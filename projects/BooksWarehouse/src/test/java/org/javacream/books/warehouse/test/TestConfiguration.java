package org.javacream.books.warehouse.test;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.DatabaseStoreService;
import org.javacream.store.impl.decorators.AuditingDecorator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class TestConfiguration {

	
	@Bean @Primary public StoreService storeService(DatabaseStoreService databaseStoreService) {
		AuditingDecorator auditingDecorator = new AuditingDecorator();
		auditingDecorator.setStoreService(databaseStoreService);
		return auditingDecorator;
	}
}
