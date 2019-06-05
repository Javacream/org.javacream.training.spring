package org.javacream.store.impl;

import javax.annotation.PostConstruct;

import org.javacream.store.api.StoreService;

public class SimpleStoreService implements StoreService {
	
	
	{
		System.out.println("****************** constructor: " + this);
	}
	@PostConstruct
	public void initTheStoreService() {
		System.out.println("****************** init: " + this);
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
