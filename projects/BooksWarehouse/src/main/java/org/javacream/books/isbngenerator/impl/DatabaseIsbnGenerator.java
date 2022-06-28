package org.javacream.books.isbngenerator.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.javacream.util.aspects.Audit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
@SequenceStrategy
@Transactional
public class DatabaseIsbnGenerator implements IsbnGenerator {
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
	@Audit
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
		int isbn = (int) entityManager.createNativeQuery("select isbn from isbns").getResultList().get(0);
		isbn++;
		Query query = entityManager.createNativeQuery("update isbns set isbn = :isbn");
		query.setParameter("isbn", isbn);
		query.executeUpdate();
		return isbn;
	}
}
