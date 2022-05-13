package org.javacream.books.store.test;

import org.javacream.JavacreamTest;
import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@JavacreamTest
public class StoreServiceTest {

	@Autowired @Database private StoreService storeService;
	
	@Test public void storeServiceWorks() {
		Assertions.assertEquals(0, storeService.getStock("this", "that"));
	}
	@Test public void categoryBooksAndItemISBN1HasStock42() {
		Assertions.assertEquals(42, storeService.getStock("books", "ISBN1"));
	}
}
