package org.javacream.store.api;

import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetStockTest {
    private StoreService storeService;
    @BeforeEach public void setUp(){
        storeService = new SimpleStoreService();
    }

    @Test public void storeServiceWorks(){
        Integer stock = storeService.getStock("ASDF", "ASDFGHJ");
        Assertions.assertEquals(0, stock);
    }
}
