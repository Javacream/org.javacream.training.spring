package org.javacream.books.isbngenerator.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
		int isbn = em.createNativeQuery("select * from ISBNS").getFirstResult();
		//TODO Korrektes Auslesen sowie Hochzählen und zurückschreiben der ISBN
		return "DATA-BASE: " + isbn;
	}

}
