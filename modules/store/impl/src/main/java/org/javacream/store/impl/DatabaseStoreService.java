package org.javacream.store.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Service;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class DatabaseStoreService implements StoreService {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public int getStock(String category, String item) {
		var query = entityManager.createNativeQuery("select stock from store where category = :category and item= :item");
		query.setParameter("category", category);
		query.setParameter("item", item);
		try {
			int stock = (int) query.getSingleResult();
			return stock;
		}catch(RuntimeException re){
			System.out.println(re.getMessage());
			return 0;
		}
	}


}
