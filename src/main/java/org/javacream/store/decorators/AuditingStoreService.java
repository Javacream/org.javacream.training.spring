package org.javacream.store.decorators;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class AuditingStoreService implements StoreService {

	@Autowired
	private StoreService delegate;


	@Override
	public int getStock(String category, String item) {
		System.out.println("calling gestStock...");
		int stock = delegate.getStock(category, item);
		return stock;
	}

}
