package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {StoreServiceConfiguration.class})

public class StoreServiceTest {

	@Autowired @Qualifier("actor1") private StoreService storeServiceForActor1;
	@Autowired @Qualifier("actor2") private StoreService storeServiceForActor2;
	@Test public void testStoreServiceForActor1() {
		System.out.println("Actor 1: " + storeServiceForActor1.getStock("", ""));
	}
	@Test public void testStoreServiceForActor2() {
		System.out.println("Actor 2: " + storeServiceForActor2.getStock("", ""));
	}
}
