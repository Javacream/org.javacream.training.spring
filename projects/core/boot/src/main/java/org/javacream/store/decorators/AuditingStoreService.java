package org.javacream.store.decorators;

import java.util.Date;

import javax.annotation.Resource;

import org.javacream.store.api.StoreService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AuditingStoreService implements StoreService {

	@Resource(name="simpleStoreService") private StoreService delegate;

	public int getStock(String category, String item) {
		System.out.println("Auditing StoreService, called getStock: category=" + category + ", item=" + item + " at " + new Date());
		return delegate.getStock(category, item);
	}
}
