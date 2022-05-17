package org.javacream.util;

import javax.annotation.PostConstruct;

public class SequenceGenerator {
	private long counter;
	
	public long nextInSequence() {
		return counter++;
	}

	@PostConstruct public void startUp() {
		System.out.println("starting up " + this);
	}
	
}
