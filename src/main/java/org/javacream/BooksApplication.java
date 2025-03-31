package org.javacream;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksApplication {

    @Bean
    public StoreService storeService(@Value("${store.defaultStock}") int defaultStock){
        SimpleStoreService simpleStoreService = new SimpleStoreService();
        simpleStoreService.setStock(defaultStock);
        return simpleStoreService;
    }
}
