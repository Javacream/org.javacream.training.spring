package org.javacream.store.config;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.decorators.AuditingStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreServiceConfiguration {

    @Bean public StoreService storeService(StoreService storeService){
        AuditingStoreService auditingStoreService = new AuditingStoreService();
        auditingStoreService.setStoreService(storeService);
        return auditingStoreService;
    }
}
