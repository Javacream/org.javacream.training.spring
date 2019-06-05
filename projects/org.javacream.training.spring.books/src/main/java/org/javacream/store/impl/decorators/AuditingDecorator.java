package org.javacream.store.impl.decorators;

import org.javacream.store.api.StoreService;

public class AuditingDecorator implements StoreService{
	
	private StoreService storeService;

	@Override
	public int getStock(String category, String item) {
		System.out.println("called getStock ...");
		return storeService.getStock(category, item);
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	

}
