package org.javacream.store.api;

import org.javacream.store.decorators.AuditingStoreServiceDecorator;
import org.javacream.util.log.api.LogService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreServiceConfiguration {

	@Bean @Qualifier("withAuditing")  StoreService storeServiceWithAuditing(StoreService databaseStoreService, LogService logService) {
		AuditingStoreServiceDecorator auditingStoreServiceDecorator = new AuditingStoreServiceDecorator();
		auditingStoreServiceDecorator.setDelegate(databaseStoreService);
		auditingStoreServiceDecorator.setLogService(logService);
		return auditingStoreServiceDecorator;
	}
	@Bean @Qualifier("plain")  StoreService storeService(StoreService databaseStoreService) {
		return databaseStoreService;
	}
}
