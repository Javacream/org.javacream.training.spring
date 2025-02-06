package org.javacream.store.config;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.decorators.AuditStoreService;
import org.javacream.store.impl.decorators.LogStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StoreConfig {
//    @Bean public StoreService storeService(@Value("${storeService.defaultStock}") int stock){
@Bean @Primary
public StoreService storeService(DatabaseStoreService databaseStoreService){
    AuditStoreService auditStoreService = new AuditStoreService();
    LogStoreService logStoreService = new LogStoreService();
    auditStoreService.setDelegate(databaseStoreService);
    logStoreService.setDelegate(auditStoreService);
    return logStoreService;
        }


}
