package org.javacream.util.audit.impl;

import java.util.Date;

import org.javacream.util.audit.api.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JdbcAuditService implements AuditService{
	@Autowired private JdbcTemplate jdbcTemplate;
	@Override
	public void log(String message) {
		String auditMessage = "Message: " + message + " at " + new Date();
		jdbcTemplate.execute("insert into AUDIT values('" + auditMessage + "')");
	}

}
