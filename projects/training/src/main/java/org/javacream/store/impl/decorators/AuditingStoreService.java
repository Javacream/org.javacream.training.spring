package org.javacream.store.impl.decorators;

import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Audit
public class AuditingStoreService implements StoreService{
	
	@Autowired @Plain private StoreService delegate;

	public void setDelegate(StoreService delegate) {
		this.delegate = delegate;
	}

	public int getStock(String category, String item) {
		System.out.println("calling getStock");
		return delegate.getStock(category, item);
	}

	@Override
	public void saveOrUpdateStock(String category, String item, int stock) {
		delegate.saveOrUpdateStock(category, item, stock);
	}

	
	

}
