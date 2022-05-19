package org.javacream.store.impl.decorators;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.store.api.StoreService;
import org.javacream.store.api.StoreService.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Audit
@Transactional
public class AuditingStoreService implements StoreService{
	
	@Autowired @Plain private StoreService delegate;

	@PersistenceContext private EntityManager entityManager;
	public void setDelegate(StoreService delegate) {
		this.delegate = delegate;
	}

	public int getStock(String category, String item) {
		String message = "calling getStock at " + new Date();
		insertMessage(message);
		return delegate.getStock(category, item);
	}

	@Override
	public void saveOrUpdateStock(String category, String item, int stock) {
		String message = "calling saveOrUpdateStock at " + new Date();
		insertMessage(message);
		delegate.saveOrUpdateStock(category, item, stock);
	}

	private void insertMessage(String message) {
		Query query = entityManager.createNativeQuery("insert into messages (message) values (:message)");
		query.setParameter("message", message);
		query.executeUpdate();
		
	}

}
