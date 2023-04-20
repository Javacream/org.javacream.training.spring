package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

//@Service
public class SimpleStoreService implements StoreService {

	public void setStock(int stock) {
		this.stock = stock;
	}

	@PostConstruct public void init(){
		System.out.println("initializing " + this);
	}
	@Value("${storeservice.defaultStock}")
	private int stock;
	
	@Override
	public int getStock(String category, String item) {
		return stock;
	}

}
