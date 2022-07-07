package org.javacream.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Service
public class JpaDemo {
    @Autowired private DataSource dataSource;//möglich, aber in der Praxis nie nötig
    //@Autowired private EntityManager entityManager;//Nur konzeptuell richtig ("injection"), entityManager hat einen ganz spezielle Scope
    @PersistenceContext private EntityManager entityManager;

    @PostConstruct public void initi(){
        System.out.println("############# " + dataSource + ", " + entityManager);
    }
}
