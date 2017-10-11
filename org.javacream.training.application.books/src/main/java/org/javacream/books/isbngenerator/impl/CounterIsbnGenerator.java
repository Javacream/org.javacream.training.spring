package org.javacream.books.isbngenerator.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
@ManagedResource(objectName = "org.javacream:type=IsbnGenerator")
public class CounterIsbnGenerator implements IsbnGenerator {

	@Value("${isbngenerator.prefix}")
	private String prefix;
	@Value("${isbngenerator.countryCode}")
	private String countryCode;

	@ManagedAttribute
	public String getCountryCode() {
		return countryCode;
	}

	@ManagedAttribute
	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	public String next() {
		int actualIsbn = jdbcTemplate.execute(new StatementCallback<Integer>() {

			@Override
			public Integer doInStatement(Statement statement) throws SQLException, DataAccessException {
				ResultSet rs = statement.executeQuery("select isbn from isbn");
				rs.next();
				int sequenceCounter = rs.getInt(1);
				sequenceCounter++;
				statement.execute("update ISBN set isbn=" + sequenceCounter);
				return sequenceCounter;
			}
		});
		return prefix + actualIsbn + countryCode;
	}

	@ManagedAttribute
	public String getPrefix() {
		return prefix;
	}

	@ManagedAttribute
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
