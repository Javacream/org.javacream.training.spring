package org.javacream;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class JavacreamConfiguration {
    @Autowired
    StoreService storeService;
    @PostConstruct public void init(){
        System.out.println("################################## " +  storeService);
    }
}
