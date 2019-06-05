package org.javacream.demo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Profile("test")
public class CatService {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	CatClinic clinic;

	@Autowired
	private CatService selfHack;

	@Transactional
	public void doCatDemo() {
		Cat cat = new Cat("Thommy", "brown", 5.55);
		System.out.println(cat.getId());
		// cat: "transient"
		entityManager.persist(cat);
		// cat: attached
		System.out.println(cat.getId());
		cat.setWeight(9.99);
		Cat searchResult = entityManager.find(Cat.class, 1l);
		System.out.println(searchResult.toString());
		searchResult.setFurColor("pink");
		System.out.println(cat.getFurColor());
		System.out.println(cat == searchResult);
		TypedQuery<Cat> query = entityManager.createQuery("select cat from Cat as cat where cat.name = :catName",
				Cat.class);
		query.setParameter("catName", "Thommy");
		List<Cat> cats = query.getResultList();
		Cat searchResult2 = cats.get(0);
		System.out.println(cat == searchResult2);
		entityManager.flush();// Schreibe in die Datenbank
		entityManager.clear();// cat detached
		Cat searchResult3 = entityManager.find(Cat.class, 1l);
		System.out.println(cat == searchResult3);
		cat.setFurColor("darkblue");
		Cat searchResult4 = entityManager.merge(cat);
		System.out.println(searchResult3.getFurColor());
		cat.setFurColor("yellow");

	}// commit: Alle attached objects werden mit der db synchronisiert

	@Transactional
	public void doCatDemoWithExternalSimulation() {
		Cat cat = entityManager.find(Cat.class, 1l);
		clinic.doSimulation();
//		entityManager.refresh(cat);
		System.out.println(cat);
	}

	@Transactional
	public void doCatDemoWithSelfSimulation() {
		Cat cat = entityManager.find(Cat.class, 1l);
		selfHack.doSimulationIntern();
//		entityManager.refresh(cat);
		System.out.println(cat);
	}

	@Transactional
	public void doCatDemoWithThisSimulation() {
		Cat cat = entityManager.find(Cat.class, 1l);
		this.doSimulationIntern();
//		entityManager.refresh(cat);
		System.out.println(cat);
	}

	@Transactional
	public void insertThommy() {
		Cat cat = new Cat("Thommy", "brown", 8.88);
		entityManager.persist(cat);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void doSimulationIntern() {
		Cat cat = entityManager.find(Cat.class, 1l);
		cat.setWeight(cat.getWeight()/2);
		System.out.println(cat);
	}

}
