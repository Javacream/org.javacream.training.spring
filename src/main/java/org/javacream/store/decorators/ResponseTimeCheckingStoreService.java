package org.javacream.store.decorators;

import javax.annotation.Resource;

import org.javacream.store.api.StoreService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ResponseTimeCheckingStoreService implements StoreService {
	@Resource(name="auditingStoreServiceDecorator")
	private StoreService storeService;



	public int getStock(String category, String item) {
		long start = System.currentTimeMillis();

		int stock = storeService.getStock(category, item);
		long end = System.currentTimeMillis();
		if ((end - start) > 100) {
			throw new RuntimeException("getStock too long");
		} else {
			return stock;
		}
	}

}
