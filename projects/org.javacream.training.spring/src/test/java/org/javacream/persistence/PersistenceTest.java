package org.javacream.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class PersistenceTest {
	@Autowired private DataSource dataSource;
	@Autowired private JdbcTemplate jdbcTemplate;
	@PersistenceContext private EntityManager entityManager;
	
	@Test public void testEnvironment() {
		Assertions.assertNotNull(dataSource);
		Assertions.assertNotNull(jdbcTemplate);
		Assertions.assertNotNull(entityManager);
	}
	

}
