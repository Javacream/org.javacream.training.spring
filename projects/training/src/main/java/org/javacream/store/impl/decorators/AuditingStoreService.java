package org.javacream.store.impl.decorators;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
public class AuditingStoreService implements StoreService{
	
	@Autowired private StoreService delegate;

	public void setDelegate(StoreService delegate) {
		this.delegate = delegate;
	}

	public int getStock(String category, String item) {
		System.out.println("calling getStock");
		return delegate.getStock(category, item);
	}

	
	

}
