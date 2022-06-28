package org.javacream.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseDemoWebService {
	
	@Autowired private DemoBusiness demo2;
	@PersistenceContext private EntityManager entityManager;

	@Transactional(propagation = Propagation.REQUIRED)
	@PostMapping(path="demo") public void doDemo(@RequestHeader("flag") boolean separatTransaction) {
		entityManager.createNativeQuery("insert into messages values ('From WebService')").executeUpdate();
		try {
			demo2.doDemo(separatTransaction);
		}
		catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

}
