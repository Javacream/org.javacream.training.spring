package org.javacream.store.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.javacream.store.api.StoreServiceAdmin;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Service;

@Service("storeServiceAdmin")
public class JdbcStoreServiceAdmin extends JdbcStoreService implements StoreServiceAdmin{

	@Override
	public void setStock(String category, String item, int stock) {
		jdbcTemplate.execute(new StatementCallback() {

			@Override
			public Object doInStatement(Statement statement) throws SQLException, DataAccessException {
				String where = " where category = '" + category + "' and item='" + item + "'";
				ResultSet rs = statement.executeQuery("select stock from STORE" + where );
				if (rs.next()) {
					statement.executeUpdate("update STORE set stock=" + stock + where);
				}
				else {
					statement.executeUpdate("insert into STORE (category, item, stock) values ('"+category + "', '" + item+"', " + stock + ")");
				}
				return null;
			}
			
		});
	}

}
