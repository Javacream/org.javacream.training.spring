package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.junit.jupiter.api.Assertions;
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
    @Test public void category_books_and_item_ISBN1hasStock42(){
        Assertions.assertEquals(42, storeService.getStock("books", "ISBN1"));
    }
    @Test public void category_dvd_and_item_0815hasStock1000(){
        Assertions.assertEquals(1000, storeService.getStock("dvd", "0815"));
    }
    @Test public void unknownHasStock0(){
        Assertions.assertEquals(0, storeService.getStock("dfghjhg", "jhgfghhg"));
    }
}
