package org.javacream;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.DatabaseStoreService;
import org.javacream.store.impl.decorators.AuditDecorator;
import org.javacream.store.impl.decorators.LoggingDecorator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BooksConfiguration {

    @Bean @Primary @Qualifier("order")
    public StoreService storeServiceForOrder(DatabaseStoreService storeService){
        AuditDecorator auditDecorator = new AuditDecorator();
        auditDecorator.setDelegate(storeService);
        return auditDecorator;
    }
    @Bean @Primary @Qualifier("books")
    public StoreService storeServiceForBook(DatabaseStoreService storeService){
        AuditDecorator auditDecorator = new AuditDecorator();
        auditDecorator.setDelegate(storeService);
        LoggingDecorator loggingDecorator = new LoggingDecorator();
        loggingDecorator.setDelegate(auditDecorator);
        return loggingDecorator;
    }

    public static void main(String[] args) {
        var app = new SpringApplication(BooksConfiguration.class);
        app.setAdditionalProfiles("prod");
        app.run(args);
    }
}
