package org.javacream.store.impl.decorators;

import org.javacream.store.api.StoreService;


public class AuditingStoreService implements StoreService{
	
	private StoreService delegate;

	public void setDelegate(StoreService delegate) {
		this.delegate = delegate;
	}

	public int getStock(String category, String item) {
		System.out.println("calling getStock");
		return delegate.getStock(category, item);
	}

	
	

}
