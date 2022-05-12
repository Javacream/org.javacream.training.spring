package org.javacream.books.store.test;

import org.javacream.JavacreamTest;
import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Audited;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@JavacreamTest
public class StoreServiceTest {

	@Autowired @Audited private StoreService storeService;
	
	@Test public void storeServiceWorks() {
		storeService.getStock("this", "that");
	}
}
