package org.javacream.store.test;

import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Audit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class StoreTest {

	@Autowired @Audit private StoreService storeService;
	@Test public void storeServiceWorks() {
		storeService.getStock("this", "that");
		
	}
}
