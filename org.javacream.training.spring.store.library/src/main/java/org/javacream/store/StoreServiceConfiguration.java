package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.decorators.AuditingStoreService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StoreServiceConfiguration {
    @Bean
    public StoreService storeService(StoreService storeService){
        AuditingStoreService auditingStoreService = new AuditingStoreService();
        auditingStoreService.setStoreService(storeService);
        return auditingStoreService;
    }
}

