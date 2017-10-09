package org.javacream.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SimpleBusiness {

	@Autowired
	private SimpleBusinessDelegate sbd;
	@Autowired
	private SimpleBusinessDelegate sbd2;
	
	@PostConstruct public void initTheSimpleBusiness() {
		sbd.doSimpleBusiness("aSimpleBusiness");
		sbd2.doSimpleBusiness("aSimpleBusiness");
	}
}
