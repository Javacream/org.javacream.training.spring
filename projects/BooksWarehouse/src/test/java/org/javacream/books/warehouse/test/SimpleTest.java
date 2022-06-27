package org.javacream.books.warehouse.test;

import org.javacream.store.impl.MapStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleTest {

	@Test public void testIt() {
		MapStoreService mapStoreService = new MapStoreService();
		mapStoreService.getStock("this", "that");
	}
	
}
