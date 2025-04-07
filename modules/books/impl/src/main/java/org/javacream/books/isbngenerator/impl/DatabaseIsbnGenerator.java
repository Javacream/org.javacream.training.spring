package org.javacream.books.isbngenerator.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@IsbnGenerator.SequenceStrategy
@Transactional(propagation = Propagation.REQUIRED)
@Profile({"dev","test", "prod"})
public class DatabaseIsbnGenerator implements IsbnGenerator {
	@PersistenceContext private EntityManager entityManager;
	@Value("${isbngenerator.prefix}") private String prefix;
	@Value("${isbngenerator.countryCode}") private String countryCode;
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}
	public String next(){
		Long counter = (Long)entityManager.createNativeQuery("select next value for ISBN").getSingleResult();
		return prefix + counter++ + countryCode;
	}

}
