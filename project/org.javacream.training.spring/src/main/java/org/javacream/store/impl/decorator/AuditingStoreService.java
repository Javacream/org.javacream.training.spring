package org.javacream.store.impl.decorator;

import java.util.Date;

import org.javacream.store.api.StoreService;

public class AuditingStoreService implements StoreService{
	
	private StoreService storeService;

	public int getStock(String category, String item) {
		System.out.println("called getStock at " + new Date());
		return storeService.getStock(category, item);
	} 

}
