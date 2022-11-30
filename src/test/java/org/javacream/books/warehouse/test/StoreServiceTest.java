package org.javacream.books.warehouse.test;

import org.assertj.core.api.Assertions;
import org.javacream.store.api.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes=StoreServiceTest.StoreTestConfiguration.class)
@ActiveProfiles("test")
public class StoreServiceTest {

	@Autowired private StoreService storeService;
	
	@Test
	public void contextLoads() {
		
	}
	@Test
	public void testStoreService() {
		Assertions.assertThat(storeService.getStock("", "")).isGreaterThan(0);
	}
	@Configuration
	@ComponentScan(basePackages = "org.javacream.store")
	public static class StoreTestConfiguration{
		
	}
}
