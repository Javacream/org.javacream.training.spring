package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.javacream.store.decorators.AuditingStoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StoreServiceConfiguration {

    @Bean
    public StoreService storeService(SimpleStoreService simpleStoreService){
        AuditingStoreService auditingStoreService = new AuditingStoreService();
        auditingStoreService.setDelegate(simpleStoreService);
        return auditingStoreService;
    }


}
