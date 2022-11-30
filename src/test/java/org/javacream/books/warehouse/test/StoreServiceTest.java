package org.javacream.books.warehouse.test;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes=SimpleStoreService.class)
@ActiveProfiles("test")
public class StoreServiceTest {

	@Autowired private StoreService storeService;
	
	@Test
	public void contextLoads() {
		
	}
	
}
