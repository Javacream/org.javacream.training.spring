package org.javacream.store.api;

public interface StoreService {
	int getStock(String category, String item);

	void updateStock(String category, String item, int amount);
}
