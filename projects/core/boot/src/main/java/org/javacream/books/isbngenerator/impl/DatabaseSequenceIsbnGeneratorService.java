package org.javacream.books.isbngenerator.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DatabaseSequenceIsbnGeneratorService implements IsbnGenerator {

	@PersistenceContext private EntityManager entityManager;
	
	private String prefix;
	
	private String countryCode;
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public String next(){
		return prefix + increment() + countryCode;
	}

	private int increment() {
		int result = (int)entityManager.createNativeQuery("select counter from ISBNCOUNTER").getSingleResult();
		result++;
		Query updateCounter = entityManager.createNativeQuery("update ISBNCOUNTER set counter=:counter");
		updateCounter.setParameter("counter", result);
		updateCounter.executeUpdate();
		return result;
	}

	public String getPrefix(){
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
