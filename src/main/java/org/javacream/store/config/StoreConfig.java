package org.javacream.store.config;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreConfig {
    @Bean public StoreService storeService(){
        SimpleStoreService storeService = new SimpleStoreService();
        storeService.setStock(42);
        return storeService;
    }
}
