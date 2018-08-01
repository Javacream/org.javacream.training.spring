package org.javacream.books.isbngenerator.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Service;

@Service
@Qualifier(IsbnGeneratorService.Algorithms.SEQUENCE)
public class DatabaseSequenceIsbnGeneratorService implements IsbnGeneratorService {

	@Value("${isbngenerator.prefix}")
	private String prefix;
	@Value("${isbngenerator.countryCode}")
	private String countryCode;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}

	public String next() {
		return prefix + nextKey() + countryCode;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	private int nextKey() {
		return jdbcTemplate.execute(new StatementCallback<Integer>() {

			@Override
			public Integer doInStatement(Statement stmt) throws SQLException, DataAccessException {
				ResultSet rs = stmt.executeQuery("select col_key from keys");
				rs.next();
				int key = rs.getInt(1);
				key++;
				stmt.executeUpdate("update keys set col_key=" + key);
				return key;
			}
		});
	}
}
