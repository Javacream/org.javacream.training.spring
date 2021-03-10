package org.javacream.books.isbngenerator.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.SequenceStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service("sequenceIsbnGenerator")
@Service
@SequenceStrategy
@Transactional
public class SequenceIsbnGeneratorService implements IsbnGeneratorService {

	@PersistenceContext private EntityManager entityManager;
	@Value("${isbn.prefix}")
	private String prefix;
	@Value("${isbn.countryCode}")
	private String countryCode;
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}
	public String next(){
		Integer isbn = (Integer) entityManager.createNativeQuery("select isbn from ISBNS").getSingleResult();
		isbn++;
		Query update = entityManager.createNativeQuery("update ISBNS set isbn = :isbn");
		update.setParameter("isbn", isbn);
		update.executeUpdate();
		return prefix + isbn++ + countryCode;
	}

	public String getPrefix(){
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
