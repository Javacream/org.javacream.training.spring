package org.javacream.store.decorators;

import java.util.Date;

import javax.annotation.Resource;

import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Component;

@Component
public class AuditingStoreServiceDecorator implements StoreService {

	@Resource(name="simpleStoreService")
	private StoreService storeService;
	@Override
	public int getStock(String category, String item) {
		System.out.println("AUDIT: called getStock at " + new Date());
		return storeService.getStock(category, item);
	}

}
