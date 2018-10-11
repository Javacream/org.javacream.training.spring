package org.javacream.store.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Service;

@Service("storeService")
public class JdbcStoreService implements StoreService {
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public int getStock(String category, String item) {
		try {
			return jdbcTemplate.execute(new StatementCallback<Integer>() {

				@Override
				public Integer doInStatement(Statement stmt) throws SQLException, DataAccessException {
					ResultSet rs = stmt.executeQuery(
							"select stock from STORE where category = '" + category + "' and item='" + item + "'");
					rs.next();
					return rs.getInt(1);
				}
			});
		} catch (RuntimeException e) {
			return 0;
		}
	}

}
