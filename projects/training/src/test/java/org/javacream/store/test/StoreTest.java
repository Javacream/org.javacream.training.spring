package org.javacream.store.test;

import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Audit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class StoreTest {

	@Autowired @Audit private StoreService storeService;

	@Test public void getStockForCategoryThisAndItemThatRetrieves0() {
		Assertions.assertEquals(0, storeService.getStock("this", "that"));
		
	}
	@Test public void getStockForCategoryBooksAndItemISBN1Retrieves42() {
		Assertions.assertEquals(42, storeService.getStock("books", "ISBN1"));
		
	}
}
