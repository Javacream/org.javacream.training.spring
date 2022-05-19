package org.javacream.util;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SequenceGenerator {
	@PersistenceContext private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public long nextInSequence() {
		return ((BigInteger)entityManager.createNativeQuery("values next value for sequencegenerator").getSingleResult()).longValue();
	}

	
}
