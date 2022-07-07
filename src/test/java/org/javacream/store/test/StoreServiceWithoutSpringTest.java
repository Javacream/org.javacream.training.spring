package org.javacream.store.test;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.DatabaseStoreService;
import org.junit.jupiter.api.Test;

public class StoreServiceWithoutSpringTest {

    @Test
    public void testSimpleStoreService() {
        StoreService ss = new DatabaseStoreService();
        System.out.println(ss.getStock("this", "that"));
    }
}
