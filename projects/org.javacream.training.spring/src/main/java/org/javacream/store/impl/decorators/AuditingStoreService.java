package org.javacream.store.impl.decorators;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.util.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AuditingStoreService implements StoreService{
	@Autowired AuditService auditService;
	@Autowired private SimpleStoreService storeService;

	public int getStock(String category, String item) {
		auditService.log("store-request", "from decorator");
		return storeService.getStock(category, item);
	}

}
