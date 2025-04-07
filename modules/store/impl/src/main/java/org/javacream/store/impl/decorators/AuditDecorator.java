package org.javacream.store.impl.decorators;

import org.javacream.store.api.StoreService;

import java.util.Date;

public class AuditDecorator implements StoreService{
    public int getStock(String category, String item) {
        System.out.println("calling getStock at " + new Date());
        return delegate.getStock(category, item);
    }

    public void setDelegate(StoreService delegate) {
        this.delegate = delegate;
    }

    private StoreService delegate;
}
