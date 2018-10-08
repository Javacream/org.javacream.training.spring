package org.javacream.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {

	@Autowired
	private A a;

	public void doSomething() {
		System.out.println("c doing something with " + a) ;
	}
}
