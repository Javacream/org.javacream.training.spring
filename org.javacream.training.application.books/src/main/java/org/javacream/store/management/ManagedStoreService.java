package org.javacream.store.management;

import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

@Service
@Primary
@ManagedResource(objectName="org.javacream:type=Service,name=Store")
public class ManagedStoreService implements StoreService {

	private int counter;
	
	private long lastAccess;
	private long resetTime;
	@ManagedAttribute(description="timestamp of last access")
	public long getLastAccess() {
		return lastAccess;
	}
	@ManagedAttribute(description="timestamp of last reset")
	public long getResetTime() {
		return resetTime;
	}
	@ManagedOperation(description="reset counter and resetTime")
	public void reset(){
		counter = 0;
		resetTime = System.currentTimeMillis();
	}
	@ManagedAttribute(description="number of invocations")
	public int getCounter() {
		return counter;
	}

	@Autowired SimpleStoreService simpleStoreService;
	
	@Override
	public int getStock(String category, String item) {
		counter++;
		lastAccess = System.currentTimeMillis();
		return simpleStoreService.getStock(category, item);
	}

}
