package org.javacream;

import org.javacream.store.api.StoreService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreServiceTest {
	@Autowired private StoreService storeService;
	
	@Test public void testJdbc() {
		int stock = storeService.getStock("book", "ISBN1");
		Assert.assertTrue(stock == 42);
		int dvdStock = storeService.getStock("dvd", "ISBN1");
		Assert.assertTrue(dvdStock == 0);
		
	}
}
