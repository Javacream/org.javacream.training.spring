package org.javacream.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service()
@Scope("prototype")
public class SimpleBusinessDelegate2 {

	@SuppressWarnings("unused")
	@Autowired  private SimpleBusiness4 sb4;
	
//	public SimpleBusinessDelegate2(@Autowired SimpleBusiness4 sb4) {
//		super();
//		this.sb4 = sb4;
//	}

	public void doSimpleBusiness(String caller) {
		System.out.println("A warm hello from " + caller + ", delegate2=" + this);
	}
}
