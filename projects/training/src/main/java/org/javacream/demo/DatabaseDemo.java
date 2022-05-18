package org.javacream.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class DatabaseDemo {
	
	@PersistenceContext private EntityManager entityManager;
	public String insertMessage(String message){//EntityTransaction transaction = entityManager.getTransaction();transaction.begin();

		Query query = entityManager.createNativeQuery("insert into messages (message) values(:newMessage)");
		query.setParameter("newMessage", message);
		int result = query.executeUpdate();
		return "OK, insert rows: " + result;
	}//transaction.commit();

	public String readMessages(){
		Query query = entityManager.createNativeQuery("select message from messages");
		return query.getResultList().toString();
		
	}
}
