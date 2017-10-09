package org.javacream.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SimpleBusiness4 {

	@Autowired  private SimpleBusinessDelegate2 sbd;

	
//	public SimpleBusiness4(@Autowired SimpleBusinessDelegate2 sbd) {
//		super();
//		this.sbd = sbd;
//	}


	@PostConstruct public void initTheSimpleBusiness() {
		sbd.doSimpleBusiness("aSimpleBusiness4");
	}
}
