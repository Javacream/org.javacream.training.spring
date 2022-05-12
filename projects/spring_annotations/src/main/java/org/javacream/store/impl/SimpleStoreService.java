package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Plain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Plain
public class SimpleStoreService implements StoreService {
	
	
	@Value("${storeService.stock}")
	private int stock;
	
	@Override
	public int getStock(String category, String item) {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
