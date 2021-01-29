package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Component
@IsbnGeneratorService.SequenceStrategy
@Transactional(propagation = Propagation.REQUIRED)
public class DatabaseSequenceIsbnGeneratorService implements IsbnGeneratorService {
	@Autowired private EntityManager entityManager;
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

		Integer actualKey = (Integer)entityManager.createNativeQuery("select key from keys").getSingleResult();
		actualKey++;
		Query update = entityManager.createNativeQuery("update keys set key = :newKey");
		update.setParameter("newKey", actualKey);
		update.executeUpdate();
		//throw new RuntimeException("DEMO ONLY");
		return prefix + actualKey++ + countryCode;
	}

	public String getPrefix(){
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
