package org.javacream.audit.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.audit.api.AuditService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JdbcAuditService implements AuditService {
	//@Autowired //Prinzipiell kein Problem, wenn es nur eine Persistence Unit gibt
	@PersistenceContext private EntityManager entityManager; //SCOPE = Singleton -> Aber EntityManager sind nicht threadfest => PROXY
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void writeAudit(String message) {
		String auditMessage = "Message: " + message + " at " + new Date();
		Query query = entityManager.createNativeQuery("insert into AUDIT values(:message)");
		query.setParameter("message", auditMessage);
		query.executeUpdate();
	}

}
