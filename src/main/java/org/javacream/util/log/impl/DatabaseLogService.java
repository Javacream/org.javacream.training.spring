package org.javacream.util.log.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.util.log.api.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DatabaseLogService implements LogService {

	@PersistenceContext private EntityManager entityManager;

	@Override
	public void log(String message) {
		Query query = entityManager.createNativeQuery("insert into logs values (:log)");
		query.setParameter("log", message);
		query.executeUpdate();
	}
}
