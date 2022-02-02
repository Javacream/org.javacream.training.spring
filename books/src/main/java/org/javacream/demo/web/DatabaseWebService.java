package org.javacream.demo.web;

import org.javacream.demo.jpa.CatManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class DatabaseWebService {
    //@Autowired private DataSource dataSource;
    @PersistenceContext private EntityManager entityManager;
    @Autowired
    CatManager catManager;
    @GetMapping(path="demo/db") public String testDb(){
        return "OK, entityManager=" + entityManager;
    }
    @GetMapping(path="demo/cat") public String testJpa(){
        catManager.doCatSequence();
        return "OK";
    }
}
