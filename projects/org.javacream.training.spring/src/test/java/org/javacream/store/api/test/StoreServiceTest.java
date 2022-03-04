package org.javacream.store.api.test;

import org.javacream.store.api.StoreService;
import org.javacream.util.AuditService;
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
	@Autowired AuditService auditService;
	@Test public void storeServiceReturnsConfiguredDefaultStock() {
		auditService.log("store-request", "from test");
		Assertions.assertEquals(defaultStock, storeService.getStock("", ""));
	}
}
