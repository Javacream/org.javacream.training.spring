package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.store.impl.decorator.Auditing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StoreConfiguration {

    @Bean public StoreService storeService(){
        StoreService ss = new SimpleStoreService();
        System.out.println(ss.getStock("this", "that"));
        return ss;
    }

    @Bean @Primary public StoreService decorator(){
        Auditing auditing = new Auditing();
        auditing.setDelegate(storeService());
        return auditing;
    }
}
