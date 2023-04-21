package org.javacream.store.api;

public interface StoreService {
	int getStock(String category, String item);
	void setStock(String category, String item, int stock);

}
