package org.javacream.training;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("simpleBusinessDelegate")
@Scope("prototype")
public class SimpleBusinessDelegate {

	public void doSimpleBusiness(String caller) {
		System.out.println("A warm hello from " + caller + ", delegate=" + this);
	}
}
