package org.javacream.books.isbngenerator.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier(IsbnGeneratorService.Algorithms.SEQUENCE)
public class DatabaseSequenceIsbnGeneratorService implements IsbnGeneratorService {

	@Value("${isbngenerator.prefix}")
	private String prefix;
	@Value("${isbngenerator.countryCode}")
	private String countryCode;

	@Autowired
	private EntityManager entityManager;

	@Autowired private DatabaseSequenceIsbnGeneratorService delegate;
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}

	//@Transactional(isolation=Isolation.READ_COMMITTED)
	public String next() {
		return prefix + delegate.nextKey() + countryCode;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@Transactional(isolation=Isolation.SERIALIZABLE)
	public int nextKey() {
		Integer key = (Integer) entityManager.createNativeQuery("select col_key from keys").getSingleResult();
		key++;
		Query query = entityManager.createNativeQuery("update keys set col_key= :key");
		query.setParameter("key", key);
		query.executeUpdate();
		return key;
	}
}
