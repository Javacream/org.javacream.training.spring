package org.javacream.store.decorators;

import javax.annotation.PostConstruct;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.DatabaseStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Decorators implements StoreService{

	@Autowired  DatabaseStoreService simpleStoreService;
	@Autowired  AuditingStoreService auditingStoreService;
	@Autowired  LoggingStoreService loggingStoreService;
	

	@PostConstruct public void init() {
		loggingStoreService.setDelegate(auditingStoreService);
		auditingStoreService.setDelegate(simpleStoreService);
		
	}
	@Override
	public int getStock(String category, String item) {
		return loggingStoreService.getStock(category, item);
	}
	
	
}
