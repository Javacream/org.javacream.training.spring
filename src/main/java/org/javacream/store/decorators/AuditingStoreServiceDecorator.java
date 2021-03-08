package org.javacream.store.decorators;

import java.util.Date;

import org.javacream.store.api.StoreService;

public class AuditingStoreServiceDecorator implements StoreService{
	private StoreService delegate;

	public void setDelegate(StoreService delegate) {
		this.delegate = delegate;
	}

	public int getStock(String category, String item) {
		System.out.println("retrieving stock for category=" + category + " and item=" + item + " at " + new Date());
		return delegate.getStock(category, item);
	}
	
}
