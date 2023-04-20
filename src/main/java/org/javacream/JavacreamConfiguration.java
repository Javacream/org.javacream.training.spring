package org.javacream;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class JavacreamConfiguration {


    public @Bean StoreService storeService(@Value("${storeservice.defaultStock}") int defaultStock){
        SimpleStoreService storeService = new SimpleStoreService();
        storeService.setStock(defaultStock);
        return storeService;
    }

}
