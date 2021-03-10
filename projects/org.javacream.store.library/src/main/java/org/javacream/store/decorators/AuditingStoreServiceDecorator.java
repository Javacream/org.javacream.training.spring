package org.javacream.store.decorators;

import java.util.Date;

import org.javacream.store.api.StoreService;
import org.javacream.util.log.api.LogService;

public class AuditingStoreServiceDecorator implements StoreService{
	private StoreService delegate;
	private LogService logService;
	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public void setDelegate(StoreService delegate) {
		this.delegate = delegate;
	}

	public int getStock(String category, String item) {
		logService.log("retrieving stock for category=" + category + " and item=" + item + " at " + new Date());
		return delegate.getStock(category, item);
	}
	
}
