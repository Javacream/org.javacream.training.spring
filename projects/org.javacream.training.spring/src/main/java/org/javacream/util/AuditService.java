package org.javacream.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuditService {

	@PersistenceContext private EntityManager entityManager;
	public void log(String category, String message) {
		Query query = entityManager.createNativeQuery("insert into AUDIT (category, message) values (:category, :message)");
		query.setParameter("category", category);
		query.setParameter("message", message);
		query.executeUpdate();
	}
}
