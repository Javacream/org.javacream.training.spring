package org.javacream.store.impl;

import org.javacream.store.api.StoreService;
import org.javacream.util.log.api.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class DatabaseStoreService implements StoreService {
    @PersistenceContext private EntityManager entityManager;
    @Autowired private LogService logService;
    @Override
    public Integer getStock(String category, String itemId) {
        try{
            Query query = entityManager.createNativeQuery("select stock from store where category=:cat and item_id=:item");
            query.setParameter("cat", category);
            query.setParameter("item", itemId);
            return (Integer)query.getSingleResult();
        }
        catch(RuntimeException e){
            return 0;
        }
    }

    @Override
    public void setStock(String category, String itemId, Integer stock) {

            Query deleteQuery = entityManager.createNativeQuery("delete from store where category=:cat and item_id=:item");
            deleteQuery.setParameter("cat", category);
            deleteQuery.setParameter("item", itemId);
            deleteQuery.executeUpdate();
            Query updateQuery = entityManager.createNativeQuery("insert into store (category, item_id, stock) values(:cat, :item, :stock)");
            updateQuery.setParameter("cat", category);
            updateQuery.setParameter("item", itemId);
            updateQuery.setParameter("stock", stock);
            updateQuery.executeUpdate();
            logService.log("changed Store at " + new Date());

    }

    @Override
    public List<String> getItemIdsForCategory(String category) {
        Query query = entityManager.createNativeQuery("select item_id from store where category=:cat");
        query.setParameter("cat", category);
        return query.getResultList();
    }

}
