package org.javacream.store.decorators;

import java.util.Date;

import org.javacream.store.api.StoreService;

public class AuditingStoreServiceDecorator implements StoreService {

	private StoreService storeService;
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	@Override
	public int getStock(String category, String item) {
		System.out.println("AUDIT: called getStock at " + new Date());
		return storeService.getStock(category, item);
	}

}
