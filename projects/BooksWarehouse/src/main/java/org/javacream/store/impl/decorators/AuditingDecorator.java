package org.javacream.store.impl.decorators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.store.api.StoreService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AuditingDecorator implements StoreService{
	
	private StoreService storeService;

	@PersistenceContext private EntityManager entityManager;
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public int getStock(String category, String item) {
		Query query = entityManager.createNativeQuery("insert into messages values (:message)");
		query.setParameter("message", "retrieving stock for category=" + category + ", item=" + item + " at " + System.currentTimeMillis());
		query.executeUpdate();
		return storeService.getStock(category, item);
	}
	
	

}
