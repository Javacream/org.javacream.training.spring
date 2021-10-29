package org.javacream.store.decorators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.books.warehouse.api.Book;
import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope("prototype")
@Transactional
public class AuditingStoreService implements StoreService {

	@PersistenceContext private EntityManager entityManager;
	@Autowired
	private StoreService delegate;


	public void setDelegate(StoreService delegate) {
		this.delegate = delegate;
	}


	@Override
	public int getStock(String category, String item) {
		int stock = delegate.getStock(category, item);
		Query query = entityManager.createNativeQuery("insert into messages values(:message)");
		query.setParameter("message", "calling getStock, category=" + category +", item" + item +", stock=" + stock);
		query.executeUpdate();
		return stock;
	}

}
