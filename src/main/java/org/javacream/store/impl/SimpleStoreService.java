package org.javacream.store.impl;

import javax.annotation.PostConstruct;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleStoreService implements StoreService {
	@Value("${defaultStock}")
	private int stock;
	
	@Override
	public int getStock(String category, String item) {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
//	public SimpleStoreService() {
//		System.out.println("constructing " + this);
//		System.out.println("defaultStock: " + stock);
//	}
	@PostConstruct  void initTheStoreService() {
		System.out.println("initializing " + this);
		System.out.println("defaultStock: " + stock);
	}

}
