package org.javacream.store.test;

import org.javacream.store.api.StoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StoreServiceTest {
	@Autowired @Qualifier("withAuditing")
	private StoreService storeService;

	@Test
	public void testStoreWithBooksAndIsbn1() {
		int stock = storeService.getStock("books", "ISBN1");
		Assertions.assertEquals(42, stock);
	}

	@Test
	public void testStoreWithDvdAndStarTrek() {
		int stock = storeService.getStock("dvd", "Star Trek");
		Assertions.assertEquals(5, stock);
	}

	@Test
	public void testStoreWithUnknownCategory() {
		int stock = storeService.getStock("%%&&//", "Star Trek");
		Assertions.assertEquals(0, stock);
	}

	@Test
	public void testStoreWithUnknownIsbn() {
		int stock = storeService.getStock("books", "ISBN%%!!");
		Assertions.assertEquals(0, stock);
	}

}
