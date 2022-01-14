package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

@Service
public class SimpleStoreService implements StoreService {
    @Value("${store.filename}")
    private String fileName;

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

    @PostConstruct
    public void initSimpleStoreService() {
        store = new Properties();
        try {
            store.load(this.getClass().getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
