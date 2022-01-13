package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
public class SimpleStoreService implements StoreService {

    private Properties store;
    @Override
    public Integer getStock(String category, String itemId) {
        try {
            String stockString = store.get(itemId).toString();
            Integer stock = Integer.parseInt(stockString);
            return stock;
        }
        catch(NullPointerException npe){
            return 0;
        }
    }

    public SimpleStoreService() {
        store = new Properties();
        try {
            store.load(this.getClass().getResourceAsStream("/store.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
