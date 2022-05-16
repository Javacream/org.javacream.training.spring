package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SimpleStoreService implements StoreService {
	
	{
		System.out.println("initializing " + this);
	}
	
	@Value("${storeservice.defaultStock}")
	private int stock;
	
	@Override
	public int getStock(String category, String item) {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
