package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatabaseStoreService implements StoreService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public int getStock(String category, String item) {
		try {
			// JdbcTemplate uses PreparedStatement internally
			return jdbcTemplate.queryForObject(
					"select stock from store where category='" + category + "' and item='" + item + "'", Integer.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

}
