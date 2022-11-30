package org.javacream.store.impl.decorators;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.store.api.StoreService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AuditingStoreService implements StoreService {
	private StoreService delegate;
	@PersistenceContext private EntityManager entityManager;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int getStock(String category, String item) {
		Query query = entityManager.createNativeQuery("insert into logs values (:message)");
		query.setParameter("message", "called getStock at " + new Date());
		query.executeUpdate();
		return delegate.getStock(category, item);
	}

	public void setDelegate(StoreService delegate) {
		this.delegate = delegate;
	}

}
