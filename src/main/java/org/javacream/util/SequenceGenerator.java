package org.javacream.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class SequenceGenerator {

    @PersistenceContext private EntityManager entityManager;

    @Transactional
    public long nextSequence() {
        int actualId = (int)entityManager.createNativeQuery("select actual_id from seq").getSingleResult();
        actualId++;
        Query query = entityManager.createNativeQuery("update seq set actual_id = :new_id");
        query.setParameter("new_id", actualId);
        query.executeUpdate();
        return actualId;
    }
}