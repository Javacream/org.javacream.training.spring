package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.decorators.AuditingStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreConfiguration {


    public @Bean StoreService storeService(AuditingStoreService auditingStoreService, DatabaseStoreService simpleStoreService){
        auditingStoreService.setDelegate(simpleStoreService);
        return auditingStoreService;
    }

}
