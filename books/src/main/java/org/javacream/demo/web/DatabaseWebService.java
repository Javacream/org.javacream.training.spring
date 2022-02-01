package org.javacream.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class DatabaseWebService {
    //@Autowired private DataSource dataSource;
    @PersistenceContext private EntityManager entityManager;
    @GetMapping(path="demo/db") public String testDb(){
        return "OK, entityManager=" + entityManager;
    }
}
