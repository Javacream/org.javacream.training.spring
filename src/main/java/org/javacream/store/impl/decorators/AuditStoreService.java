package org.javacream.store.impl.decorators;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AuditStoreService implements StoreService{
    public int getStock(String category, String item) {
        System.out.println("****************** Called getStock");
        return delegate.getStock(category, item);
    }

    public void setDelegate(StoreService delegate) {
        this.delegate = delegate;
    }

    private StoreService delegate;
}
