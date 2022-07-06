package org.javacream.store.test;

import org.javacream.store.api.StoreService;
import org.javacream.util.SpringTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringTest
public class StoreServiceTest {
    @Autowired
    StoreService storeService;
    @Test public void testStoreService(){

        Assertions.assertNotNull(storeService.getStock("this", "that"));
    }
}
