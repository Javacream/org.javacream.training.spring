package org.javacream.books.isbngenerator.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service 
@SequenceStrategy
public class DatabaseSequenceIsbnGenerator implements IsbnGenerator {
	@PersistenceContext private EntityManager entityManager;
	@Value("${isbngenerator.prefix}")
	private String prefix;
	@Value("${isbngenerator.countryCode}")
	private String countryCode;
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}
	public String next(){
		return prefix + getNextValue() + countryCode;
	}

	public String getPrefix(){
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	private int getNextValue() {
		return ((BigInteger)entityManager.createNativeQuery("select nextval('isbn')").getSingleResult()).intValue();
	}
}
