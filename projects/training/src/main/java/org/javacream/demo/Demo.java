package org.javacream.demo;

import javax.annotation.PostConstruct;

import org.javacream.util.SequenceGenerator;

public class Demo {
	
	private SequenceGenerator sg;
	
	public void setSg(SequenceGenerator sg) {
		this.sg = sg;
	}

	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}

	{
		System.out.println("################### constructing " +this + ", gen=" + this.sg);
	}
	
	@PostConstruct public void init() {
		System.out.println("################### initializing " +this + ", gen=" + this.sg);
		
	}

}
