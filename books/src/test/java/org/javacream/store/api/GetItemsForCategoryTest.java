package org.javacream.store.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")

public class GetItemsForCategoryTest {
    @Autowired
    private StoreService storeService;
    @Test public void fourItemsForCategoryBooks(){
        Assertions.assertEquals(4, storeService.getItemIdsForCategory("books").size());
    }
    @Test public void noItemsForCategoryDvd(){
        Assertions.assertEquals(0, storeService.getItemIdsForCategory("dvd").size());
    }
}
