package org.javacream.store.config;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class StoreConfig {
//    @Bean public StoreService storeService(@Value("${storeService.defaultStock}") int stock){
@Bean public StoreService storeService(){
    SimpleStoreService storeService = new SimpleStoreService();
    System.out.println(storeService.getStock("egal", "egal"));
    return storeService;
    }


}
