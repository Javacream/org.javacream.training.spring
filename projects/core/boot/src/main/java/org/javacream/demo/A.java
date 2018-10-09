package org.javacream.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
	@Autowired
	private B b;
	
	public void domething() {
		b.doSomething();
	}
}
