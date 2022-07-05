package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SimpleStoreService implements StoreService {
	@Value("${storeService.defaultStock}")
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
