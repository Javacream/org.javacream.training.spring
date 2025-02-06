package org.javacream.store.config;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.store.impl.decorators.AuditStoreService;
import org.javacream.store.impl.decorators.LogStoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class StoreConfig {
//    @Bean public StoreService storeService(@Value("${storeService.defaultStock}") int stock){
@Bean @Primary
public StoreService storeService(SimpleStoreService simpleStoreService){
    AuditStoreService auditStoreService = new AuditStoreService();
    LogStoreService logStoreService = new LogStoreService();
    auditStoreService.setDelegate(simpleStoreService);
    logStoreService.setDelegate(auditStoreService);
    return logStoreService;
        }


}
