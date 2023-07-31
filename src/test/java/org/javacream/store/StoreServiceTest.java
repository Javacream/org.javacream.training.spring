package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class StoreServiceTest {
    @Autowired
    StoreService storeService;

    @Test public void simple(){
        System.out.println(storeService);
    }
}
