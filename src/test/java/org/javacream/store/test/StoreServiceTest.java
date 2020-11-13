package org.javacream.store.test;

import org.javacream.store.api.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class StoreServiceTest {

	@Autowired @Qualifier("forTest") private StoreService storeService;
	@Test public void testStoreService() {
		System.out.println(storeService.getStock("this", "that"));
	}
}
