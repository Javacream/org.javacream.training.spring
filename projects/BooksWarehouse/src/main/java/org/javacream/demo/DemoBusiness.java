package org.javacream.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DemoBusiness {
	
	@PersistenceContext private EntityManager entityManager;
	
	//Dieses self ist nicht (!) this, sondern der Transaction Proxy!
	@Autowired private DemoBusiness self;
	
	public void doDemo(boolean flag) {
		if (flag) {
			self.doRequiresNew();
		}else {
			self.doRequired();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void doRequired() {
		entityManager.createNativeQuery("insert into messages values ('required')").executeUpdate();
		throw new RuntimeException("TEST-ONLY");
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void doRequiresNew() {
		entityManager.createNativeQuery("insert into messages values ('requires new')").executeUpdate();
		throw new RuntimeException("TEST-ONLY");
	}

}
