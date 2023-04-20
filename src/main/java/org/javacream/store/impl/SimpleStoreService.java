package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SimpleStoreService implements StoreService {

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Value("${storeservice.defaultStock}")
	private int stock;
	
	@Override
	public int getStock(String category, String item) {
		return stock;
	}

}
