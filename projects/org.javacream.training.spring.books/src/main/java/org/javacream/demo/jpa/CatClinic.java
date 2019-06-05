package org.javacream.demo.jpa;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CatClinic {
	
	@Autowired private EntityManager entityManager;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void doSimulation() {
		Cat cat = entityManager.find(Cat.class, 1l);
		cat.setWeight(cat.getWeight()/2);
		System.out.println(cat);
	}

}
