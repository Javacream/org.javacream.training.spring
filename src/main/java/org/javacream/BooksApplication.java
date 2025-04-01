package org.javacream;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.store.impl.decorators.AuditDecorator;
import org.javacream.store.impl.decorators.LoggingDecorator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class BooksApplication {

    @Bean @Primary @Qualifier("order")
    public StoreService storeServiceForOrder(SimpleStoreService storeService){
        AuditDecorator auditDecorator = new AuditDecorator();
        auditDecorator.setDelegate(storeService);
        return auditDecorator;
    }
    @Bean @Primary @Qualifier("books")
    public StoreService storeServiceForBook(SimpleStoreService storeService){
        AuditDecorator auditDecorator = new AuditDecorator();
        auditDecorator.setDelegate(storeService);
        LoggingDecorator loggingDecorator = new LoggingDecorator();
        loggingDecorator.setDelegate(auditDecorator);
        return loggingDecorator;
    }

    public static void main(String[] args) {
        var app = new SpringApplication(BooksApplication.class);
        app.setAdditionalProfiles("prod");
        app.run(args);
    }
}
