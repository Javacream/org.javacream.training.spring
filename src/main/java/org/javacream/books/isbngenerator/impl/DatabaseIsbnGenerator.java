package org.javacream.books.isbngenerator.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Service
@IsbnGenerator.SequenceStrategy
@Profile("prod")
public class DatabaseIsbnGenerator implements IsbnGenerator {

	@PersistenceContext
	private EntityManager em;

	@Transactional(propagation = Propagation.REQUIRED)
	public String next(){
		int isbn = (int) em.createNativeQuery("select * from ISBNS").getSingleResult();
		int newIsbn = ++isbn;
		Query query = em.createNativeQuery("update ISBNS set isbn = :isbn");
		query.setParameter("isbn", newIsbn);
		query.executeUpdate();
		return "DATA-BASE: " + isbn;
	}

}
