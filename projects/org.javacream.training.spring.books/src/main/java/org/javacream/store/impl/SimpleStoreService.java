package org.javacream.store.impl;

import org.javacream.store.api.StoreService;

public class SimpleStoreService implements StoreService {
	private int stock;
	
	@Override
	public int getStock(String category, String item) {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
