package org.javacream.demo.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class EnvironmentTest {
    @Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @PersistenceContext() private EntityManager entityManager;

    @Test public void environmentIsPresent(){

    }

    @Test public void jdbcTemplateIsWorking(){
        List<String> result = jdbcTemplate.queryForObject("select * from messages", List.class);
        //...

    }

    @Test public void entityManagerIsWorking(){
        List<String> result = entityManager.createNativeQuery("select * from messages").getResultList();
        //...

    }

}
