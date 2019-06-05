package org.javacream.demo.jdbc;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDemo {

	@Autowired private DataSource ds;
	@Autowired private JdbcTemplate jdbcTemplate;
	@PostConstruct public void demo() {
		System.out.println("DataSource: " + ds + ", jdbcTemplate: " + jdbcTemplate);
		//jdbcTemplate.execute("create table DEMO (demo varchar(16))");
	}
}
