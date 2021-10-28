package org.javacream.store.decorators;

import org.javacream.store.api.StoreService;

//@Component
public class AuditingStoreService implements StoreService {

	//@Autowired 
	private StoreService delegate;
	public void setDelegate(StoreService delegate) {
		this.delegate = delegate;
	}
	@Override
	public int getStock(String category, String item) {
		System.out.println("calling gestStock...");
		int stock = delegate.getStock(category, item);
		return stock;
	}

}
