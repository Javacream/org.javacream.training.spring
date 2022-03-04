package org.javacream.store.impl.decorators;

import org.javacream.store.api.StoreService;
import org.javacream.util.AuditService;
import org.springframework.beans.factory.annotation.Autowired;

public class AuditingStoreService implements StoreService{
	@Autowired AuditService auditService;
	@Autowired private StoreService storeService;

	public int getStock(String category, String item) {
		auditService.log("store-request", "from decorator");
		return storeService.getStock(category, item);
	}

}
