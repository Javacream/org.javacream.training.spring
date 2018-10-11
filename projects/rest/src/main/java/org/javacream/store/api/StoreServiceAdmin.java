package org.javacream.store.api;

public interface StoreServiceAdmin{
	int getStock(String category, String item);
	public void setStock(String category, String item, int stock);
}
