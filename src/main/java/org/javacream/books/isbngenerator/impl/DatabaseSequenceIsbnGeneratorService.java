package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Component
@IsbnGeneratorService.SequenceStrategy
@Transactional
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
		return prefix + actualKey++ + countryCode;
	}

	public String getPrefix(){
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
