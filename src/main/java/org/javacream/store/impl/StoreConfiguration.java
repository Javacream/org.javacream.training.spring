package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreConfiguration {


    public @Bean StoreService storeService(){
        SimpleStoreService storeService = new SimpleStoreService();
        return storeService;
    }

}
