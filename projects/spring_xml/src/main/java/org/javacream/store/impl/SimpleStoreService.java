package org.javacream.store.impl;

import javax.annotation.PostConstruct;

import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Service;

@Service("storeService")
public class SimpleStoreService implements StoreService {
	@PostConstruct public void init() {
		System.out.println("'''''''''''''''''''''''''''''''''''''''");
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
