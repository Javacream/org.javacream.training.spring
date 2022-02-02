package org.javacream.demo.jpa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class CatManager {
    @PersistenceContext private EntityManager entityManager;

    public void createThommyTheCat(){
        Cat thommy = new Cat("Thommy", 3.99, "brown");
        entityManager.persist(thommy);
    }
    public void findThommyTheCat(){
        Cat result1 = entityManager.find(Cat.class, 1l);
        Cat result2 = entityManager.createQuery("select cat from CatEntity as cat where cat.name='Thommy'", Cat.class).getSingleResult();
        Cat result3 = entityManager.createQuery("select c from CatEntity as c", Cat.class).getResultList().get(0);
        result1.setFurColor("pink");
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result1 == result2);
    }
}
