package org.javacream.audit.impl;

import java.util.Date;

import org.javacream.audit.api.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JdbcAuditService implements AuditService {
	@Autowired private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void writeAudit(String message) {
		String auditMessage = "Message: " + message + " at " + new Date();
		jdbcTemplate.execute("insert into AUDIT values('" + auditMessage + "')");
	}

}
