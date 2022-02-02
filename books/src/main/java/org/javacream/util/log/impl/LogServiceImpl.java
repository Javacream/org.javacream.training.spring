package org.javacream.util.log.impl;

import org.javacream.util.log.api.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
@Transactional//(propagation = Propagation.REQUIRES_NEW)
public class LogServiceImpl implements LogService {
    @PersistenceContext private EntityManager entityManager;
    @Override
    public void log(String message) {
        Query query = entityManager.createNativeQuery("insert into logs values(:message)");
        query.setParameter("message", message);
        query.executeUpdate();
    }
}
