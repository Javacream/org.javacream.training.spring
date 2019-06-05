package org.javacream.demo.database;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatabaseDemo {

	@Autowired private DataSource ds;
	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private EntityManager entityManager;
	
	
	@Transactional
	public void demo() {
		System.out.println("DataSource: " + ds + ", jdbcTemplate: " + jdbcTemplate + ", entityManager: " + entityManager);
		//jdbcTemplate.execute("create table DEMO (demo varchar(16))");
		Query query = entityManager.createNativeQuery("select * from TEST_MESSAGES");
		List<?> resultList = query.getResultList();
		System.out.println("*********************** " + resultList);
		Query query2 = entityManager.createNativeQuery("insert into TEST_MESSAGES values (:message)");
		query2.setParameter("message", "Moon");
		query2.executeUpdate();

	}
}
