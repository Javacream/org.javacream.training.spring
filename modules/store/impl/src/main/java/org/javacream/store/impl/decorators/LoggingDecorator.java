package org.javacream.store.impl.decorators;

import org.javacream.store.api.StoreService;

public class LoggingDecorator implements StoreService{
    public int getStock(String category, String item) {
        int stock = delegate.getStock(category, item);
        System.out.println("calling getStock with category=" + category + ", item=" + item + ", stock=" + stock);
        return stock;
    }

    public void setDelegate(StoreService delegate) {
        this.delegate = delegate;
    }

    private StoreService delegate;
}
