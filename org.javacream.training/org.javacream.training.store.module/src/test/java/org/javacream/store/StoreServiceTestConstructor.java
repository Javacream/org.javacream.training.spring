package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles({"test", "constructor"})
public class StoreServiceTestConstructor {

	@Autowired private StoreService storeService;
	
	@Test public void contextLoads() {
		Assert.assertNotNull(storeService);
	}
	@Test public void configurationOk() {
		Assert.assertEquals(0, storeService.getStock("cat", "item"));
	}
}
