package org.javacream;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class JavacreamConfiguration {

    public @Bean StoreService storeService(){
        SimpleStoreService storeService = new SimpleStoreService();
        storeService.setStock(4711);
        return storeService;
    }

}
