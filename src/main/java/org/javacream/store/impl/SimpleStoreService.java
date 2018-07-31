package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Service;

@Service
public class SimpleStoreService implements StoreService {
	private int stock;
	
	@Override
	public int getStock(String category, String item) {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
