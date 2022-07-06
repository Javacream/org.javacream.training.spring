package org.javacream.store.impl.decorator;

import org.javacream.store.api.StoreService;

public class Auditing implements StoreService {

    private StoreService delegate;

    public void setDelegate(StoreService storeService){
        this.delegate = storeService;
    }
    @Override
    public int getStock(String category, String item) {
        System.out.println("calling getStock at " + System.currentTimeMillis());
        return delegate.getStock(category, item);
    }
}
