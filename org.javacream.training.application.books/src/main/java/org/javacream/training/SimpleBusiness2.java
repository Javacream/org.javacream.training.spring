package org.javacream.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleBusiness2 {

	@Autowired SimpleBusinessDelegate sbd;
	
	
	public void initTheSimpleBusiness2() {
		sbd.doSimpleBusiness("aSimpleBusiness2");
	}
}
