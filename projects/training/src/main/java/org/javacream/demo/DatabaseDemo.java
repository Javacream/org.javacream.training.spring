package org.javacream.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class DatabaseDemo {
	
	@PersistenceContext private EntityManager entityManager;
	@PostMapping(path = "demo/messages/{m}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String insertMessage(@PathVariable("m") String message){//EntityTransaction transaction = entityManager.getTransaction();transaction.begin();

		Query query = entityManager.createNativeQuery("insert into messages (message) values(:newMessage)");
		query.setParameter("newMessage", message);
		int result = query.executeUpdate();
		return "OK, insert rows: " + result;
	}//transaction.commit();

	@GetMapping(path = "demo/messages", produces = MediaType.TEXT_PLAIN_VALUE)
	public String readMessage(){
		Query query = entityManager.createNativeQuery("select message from messages");
		return query.getResultList().toString();
		
	}
}
