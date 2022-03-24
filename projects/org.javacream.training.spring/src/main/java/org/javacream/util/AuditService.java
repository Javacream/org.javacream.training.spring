package org.javacream.util;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuditService {

	@Autowired private EntityManager entityManager;
	public void log(String category, String message) {
		Query query = entityManager.createNativeQuery("insert into AUDIT (category, message) values (:category, :message)");
		query.setParameter("category", category);
		query.setParameter("message", message);
		query.executeUpdate();
	}
}
