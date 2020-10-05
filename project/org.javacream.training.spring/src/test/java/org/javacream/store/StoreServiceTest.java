package org.javacream.store;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

//@SpringBootTest(classes=StoreServiceTest.InnerStoreServiceTestConfiguration.class)
@SpringBootTest

//@SpringBootTest(classes=OuterStoreServiceTestConfiguration.class)
public class StoreServiceTest {

	@Autowired private StoreService storeService;
	//@Autowired @IsbnGenerator.SequenceStrategy private IsbnGenerator isbnGenerator;
	
	@Test public void testStoreService() {
		System.out.println(storeService.getStock("", ""));
	}
	//@SpringBootConfiguration
	public static class InnerStoreServiceTestConfiguration{
		@Value("${defaultStock}") private int stock;
		
		@Bean public StoreService storeService() {
			SimpleStoreService simpleStoreService = new SimpleStoreService();
			simpleStoreService.setStock(stock);
			return simpleStoreService;
		}
	}
}
