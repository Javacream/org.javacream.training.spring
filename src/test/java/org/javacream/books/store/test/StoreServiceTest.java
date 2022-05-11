package org.javacream.books.store.test;

import org.javacream.store.api.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StoreServiceTest {

	@Autowired private StoreService storeService;
	
	@Test public void storeServiceWorks() {
		storeService.getStock("this", "that");
	}
}
