package org.javacream.store.impl.decorator;

import java.util.Date;

import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@Audited
public class AuditingStoreService implements StoreService{

	@Autowired @Plain private StoreService delegate;

	public void setDelegate(StoreService delegate) {
		this.delegate = delegate;
	}

	public int getStock(String category, String item) {
		System.out.println("calling getStock at " + new Date());
		return delegate.getStock(category, item);
	}
}
