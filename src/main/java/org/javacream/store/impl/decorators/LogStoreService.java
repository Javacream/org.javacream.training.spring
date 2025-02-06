package org.javacream.store.impl.decorators;

import org.javacream.store.api.StoreService;

public class LogStoreService implements StoreService{
    public int getStock(String category, String item) {
        System.out.println("****************** Logging getStock call");
        return delegate.getStock(category, item);
    }

    public void setDelegate(StoreService delegate) {
        this.delegate = delegate;
    }

    private StoreService delegate;
}
