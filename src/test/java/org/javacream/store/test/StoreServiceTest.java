package org.javacream.store.test;

import org.javacream.store.api.StoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class StoreServiceTest {
    @Autowired private StoreService storeService;
    @Value("${storeService.defaultStock}") private int expectedStock;
    @Test public void testStoreService(){
        Assertions.assertEquals(expectedStock, storeService.getStock("this", "that"));
    }
}
