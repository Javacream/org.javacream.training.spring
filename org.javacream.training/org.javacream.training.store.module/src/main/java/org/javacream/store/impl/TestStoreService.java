package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class TestStoreService implements StoreService {

	@Override
	public int getStock(String category, String item) {
		return 0;
	}


}
