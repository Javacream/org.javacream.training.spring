package org.javacream;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.DatabaseStoreService;
import org.javacream.store.impl.decorators.AuditingDecorator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfiguration {
	@Bean @Primary public StoreService storeService(DatabaseStoreService databaseStoreService) {
		AuditingDecorator auditingDecorator = new AuditingDecorator();
		auditingDecorator.setStoreService(databaseStoreService);
		return auditingDecorator;
	}

	
}
