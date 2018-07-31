package org.javacream.store.decorators;

import org.javacream.store.api.StoreService;

public class ResponseTimeCheckingStoreService implements StoreService {
	private StoreService storeService;

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public int getStock(String category, String item) {
		long start = System.currentTimeMillis();

		int stock = storeService.getStock(category, item);
		long end = System.currentTimeMillis();
		if ((end - start) > 10) {
			throw new RuntimeException("getStock too long");
		} else {
			return stock;
		}
	}

}
