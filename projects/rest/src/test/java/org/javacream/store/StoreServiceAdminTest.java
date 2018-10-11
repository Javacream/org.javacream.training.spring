package org.javacream.store;


import org.javacream.store.api.StoreServiceAdmin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreServiceAdminTest {
	@Autowired private StoreServiceAdmin storeServiceAdmin;
	
	@Test public void testJdbc() {
		storeServiceAdmin.setStock("book", "ISBN1", 123);
		Assert.assertTrue(storeServiceAdmin.getStock("book", "ISBN1")== 123);
		int dvdStock = storeServiceAdmin.getStock("dvd", "DVD1");
		Assert.assertTrue(dvdStock == 0);
		storeServiceAdmin.setStock("dvd", "DVD1", 123);
		Assert.assertTrue(storeServiceAdmin.getStock("dvd", "DVD1")== 123);
		
		
	}
}
