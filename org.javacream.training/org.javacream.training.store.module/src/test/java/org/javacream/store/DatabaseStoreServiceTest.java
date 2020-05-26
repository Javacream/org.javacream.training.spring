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
@ActiveProfiles("prod")
public class DatabaseStoreServiceTest {

	@Autowired private StoreService storeService;
	
	@Test public void contextLoads() {
		Assert.assertNotNull(storeService);
	}
	@Test public void stockForIsbn1Is42() {
		Assert.assertEquals(42, storeService.getStock("books", "ISBN1"));
	}
	@Test public void stockForUnknownIsbn1Is0() {
		Assert.assertEquals(0, storeService.getStock("books", "&%&!"));
	}
}
