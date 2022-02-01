package org.javacream.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;

@Service
@Scope("singleton")
@Transactional
public class IdGenerator {

    @PersistenceContext private EntityManager entityManager;
    public Long nextId(){
        BigInteger id = (BigInteger) entityManager.createNativeQuery("select id from id").getSingleResult();
        BigInteger newId = id.add(BigInteger.ONE);
        Query query = entityManager.createNativeQuery("update id set id = :id");
        query.setParameter("id", newId);
        query.executeUpdate();
        return newId.longValue();
    }
}
