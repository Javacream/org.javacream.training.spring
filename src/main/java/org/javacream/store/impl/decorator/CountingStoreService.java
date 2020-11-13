package org.javacream.store.impl.decorator;

import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Component;

@Component
public class CountingStoreService implements StoreService {
	private int counter = 0;
	private StoreService storeService;

	public int getStock(String category, String item) {
		counter++;
		System.out.println("called getStock " + counter + " times");
		return storeService.getStock(category, item);
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

}