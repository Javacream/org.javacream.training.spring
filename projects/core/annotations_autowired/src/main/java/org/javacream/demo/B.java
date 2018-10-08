package org.javacream.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {

	@Autowired private C c;

	public void doSomething() {
		System.out.println("doing something b");
		c.doSomething();
		
	}
}
