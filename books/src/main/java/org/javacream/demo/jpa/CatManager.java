package org.javacream.demo.jpa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class CatManager {
    @PersistenceContext private EntityManager entityManager;

    public void doCatSequence(){
        Cat thommy = new Cat("Thommy", 3.99, "brown");
        entityManager.persist(thommy);
    }
}
