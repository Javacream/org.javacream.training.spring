package org.javacream.store.impl;

import java.util.Map;
import java.util.Objects;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MapStoreService implements StoreService{


	@Autowired @Qualifier("stock") private Map<StoreKey, Integer> store;
	
	@Override
	public int getStock(String category, String item) {
		Integer stock = store.get(new StoreKey(category, item));
		if (stock != null) {
			return stock;
		}else {
			return 0;
		}
	}

public static class StoreKey{
	public StoreKey(String category, String item) {
		super();
		this.category = category;
		this.item = item;
	}
	private String category;
	private String item;
	@Override
	public int hashCode() {
		return Objects.hash(category, item);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreKey other = (StoreKey) obj;
		return Objects.equals(category, other.category) && Objects.equals(item, other.item);
	}
	
	
	
}
	
}
