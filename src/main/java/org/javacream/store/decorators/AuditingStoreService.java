package org.javacream.store.decorators;

import org.javacream.store.api.StoreService;

public class AuditingStoreService implements StoreService {
    public void setDelegate(StoreService delegate) {
        this.delegate = delegate;
    }

    private StoreService delegate;

    @Override
    public int getStock(String category, String item) {
        System.out.println("called getStock...");
        return delegate.getStock(category, item);
    }
}
