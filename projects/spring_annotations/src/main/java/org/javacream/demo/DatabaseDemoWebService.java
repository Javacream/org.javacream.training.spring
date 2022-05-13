package org.javacream.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseDemoWebService {

	//@Autowired 
	@PersistenceContext
	private EntityManager entityManager;
	@GetMapping(path="api/demo", produces = MediaType.TEXT_PLAIN_VALUE) public String doDatabaseQuery() {
		return entityManager.createNativeQuery("select * from messages").getResultList().get(0).toString();
	}

	@GetMapping(path="api/demo_insert", produces = MediaType.TEXT_PLAIN_VALUE) 
	@Transactional
	public void doDatabaseInsert() {//EntityTransaction transaction = entityManager.getTransaction();transaction.begin();
//		EntityTransaction transaction = entityManager.getTransaction();
//		transaction.begin();
		Query query = entityManager.createNativeQuery("insert into messages (message) values (:m)");
		query.setParameter("m", "Hello");
		query.executeUpdate();
//		transaction.commit();
	}//transaction.commit()

}
