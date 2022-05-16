package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Component;

@Component
public class SimpleStoreService implements StoreService {
	
	{
		System.out.println("initializing " + this);
	}
	private int stock;
	
	@Override
	public int getStock(String category, String item) {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
