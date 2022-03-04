package org.javacream.store.api.test;

import org.javacream.store.api.StoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class StoreServiceTest {
	@Autowired StoreService storeService;
	@Value("${store.defaultStock}") int defaultStock;
	@Test public void storeServiceReturnsConfiguredDefaultStock() {
		Assertions.assertEquals(defaultStock, storeService.getStock("", ""));
	}
}
