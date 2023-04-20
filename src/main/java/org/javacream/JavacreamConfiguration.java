package org.javacream;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class JavacreamConfiguration {


    public @Bean StoreService storeService(){
        SimpleStoreService storeService = new SimpleStoreService();
        System.out.println("**************** CALLING storeService");
        return storeService;
    }


    public @Bean @Qualifier("greeting")  String greeting(){
        this.storeService();
        this.storeService();
        this.storeService();
        this.storeService();
        System.out.println(this.storeService());
      return "Hello";
    }
    public @Bean @Qualifier("who") String who(){
        System.out.println(this.storeService());
        return "World";
    }

}
