package org.javacream.store.impl.decorator;

import java.util.Date;

import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Component;

@Component
public class AuditingStoreService implements StoreService{
	
	private StoreService storeService;

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public int getStock(String category, String item) {
		System.out.println("called getStock at " + new Date());
		return storeService.getStock(category, item);
	} 

}
