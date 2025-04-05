package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.DatabaseStoreService;
import org.javacream.store.impl.decorators.AuditDecorator;
import org.javacream.store.impl.decorators.LoggingDecorator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class StoreConfiguration {
    @Bean
    @Primary
    @Qualifier("order")
    public StoreService storeServiceForOrder(StoreService storeService){
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

}
