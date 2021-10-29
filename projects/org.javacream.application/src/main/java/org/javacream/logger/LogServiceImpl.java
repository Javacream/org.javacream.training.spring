package org.javacream.logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.NEVER)
@Service
public class LogServiceImpl implements LogService{
	@PersistenceContext private EntityManager entityManager;


	@Override
	public void log(String message) {
		Query query = entityManager.createNativeQuery("insert into messages values(:message)");
		query.setParameter("message", message);
		query.executeUpdate();
		throw new RuntimeException ("EXPECTED");
	}

}
