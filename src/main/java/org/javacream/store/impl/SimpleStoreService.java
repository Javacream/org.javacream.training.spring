package org.javacream.store.impl;

import org.javacream.store.api.StoreService;

import javax.annotation.PostConstruct;

public class SimpleStoreService implements StoreService {
	private int stock;
	
	@Override
	public int getStock(String category, String item) {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	public SimpleStoreService(){
		System.out.println("Initializing SimpleStoreService, stock= " + stock);
	}

	@PostConstruct
	public void setup(){
		System.out.println("PostConstructing SimpleStoreService, stock= " + stock);
	}
}
