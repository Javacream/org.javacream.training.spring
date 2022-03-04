package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.javacream.util.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SimpleStoreService implements StoreService {
	@Value("${store.defaultStock}")
	private int stock;
	@Autowired StoreService storeService;
	@Value("${store.defaultStock}") int defaultStock;
	@Override
	public int getStock(String category, String item) {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
