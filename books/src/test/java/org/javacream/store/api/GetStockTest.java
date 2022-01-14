package org.javacream.store.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetStockTest {
    @Autowired
    private StoreService storeService;
    @Test public void storeServiceWorks(){
        Integer stock = storeService.getStock("ASDF", "ASDFGHJ");
        Assertions.assertEquals(0, stock);
    }
}
