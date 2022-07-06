package org.javacream.store.impl.decorator;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Auditing implements StoreService {

    @Autowired
    private SimpleStoreService delegate;

    @Override
    public int getStock(String category, String item) {
        System.out.println("calling getStock at " + System.currentTimeMillis());
        return delegate.getStock(category, item);
    }
}
