package org.javacream.store.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.javacream.store.api.StoreServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("storeServiceAdmin")

public class JdbcStoreServiceAdmin implements StoreServiceAdmin {
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

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void setStock(String category, String item, int stock) {
		jdbcTemplate.execute(new StatementCallback() {

			@Override
			public Object doInStatement(Statement statement) throws SQLException, DataAccessException {
				String where = " where category = '" + category + "' and item='" + item + "'";
				ResultSet rs = statement.executeQuery("select stock from STORE" + where);
				if (rs.next()) {
					statement.executeUpdate("update STORE set stock=" + stock + where);
				} else {
					statement.executeUpdate("insert into STORE (category, item, stock) values ('" + category + "', '"
							+ item + "', " + stock + ")");
				}
				return null;
			}

		});
	}
}
