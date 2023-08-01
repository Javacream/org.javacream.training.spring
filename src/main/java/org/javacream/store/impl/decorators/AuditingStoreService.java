package org.javacream.store.impl.decorators;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AuditingStoreService implements StoreService{

    public int getStock(String category, String item) {
        System.out.println("calling getStock");
        return storeService.getStock(category, item);
    }

    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    private StoreService storeService;

}
