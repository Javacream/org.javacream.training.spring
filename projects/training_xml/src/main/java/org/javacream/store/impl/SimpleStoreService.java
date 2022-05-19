package org.javacream.store.impl;

import org.javacream.store.api.StoreService;

public class SimpleStoreService implements StoreService {

	{
		System.out.println("constructing " + this);
	}

	public void initialize() {
		System.out.println("initializing " + this);

	}

	public void remove() {
		System.out.println("destroying " + this);

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
