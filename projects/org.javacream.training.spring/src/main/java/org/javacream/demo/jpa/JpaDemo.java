package org.javacream.demo.jpa;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class JpaDemo {
	
	@PersistenceContext private EntityManager entityManager;
	
	@PostConstruct public void init() {
		System.out.println("################## " + this.entityManager);
	}

}
