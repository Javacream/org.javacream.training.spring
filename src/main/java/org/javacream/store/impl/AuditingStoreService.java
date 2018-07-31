package org.javacream.store.impl;

import java.util.Date;

public class AuditingStoreService extends SimpleStoreService {

	@Override
	public int getStock(String category, String item) {
		System.out.println("AUDIT: called getStock at " + new Date());
		return super.getStock(category, item);
	}

}
