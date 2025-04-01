package org.javacream;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.store.impl.decorators.AuditDecorator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class BooksApplication {

    @Bean @Primary
    public StoreService storeService(StoreService storeService){
        AuditDecorator auditDecorator = new AuditDecorator();
        auditDecorator.setDelegate(storeService);
        return auditDecorator;
    }
}
