package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.javacream.store.decorators.AuditingStoreService;
import org.javacream.store.impl.DatabaseStoreService;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StoreServiceConfiguration {

    //@Bean
    public StoreService storeService(DatabaseStoreService simpleStoreService){
        AuditingStoreService auditingStoreService = new AuditingStoreService();
        auditingStoreService.setDelegate(simpleStoreService);
        return auditingStoreService;
    }


}
