package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class SimpleStoreService implements StoreService {

	@Value("${store.defaultStock}")
	private int stock;
	
	@Override
	public int getStock(String category, String item) {
		System.out.println(this);
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
