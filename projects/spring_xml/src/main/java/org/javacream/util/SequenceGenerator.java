package org.javacream.util;

import org.springframework.stereotype.Component;

@Component
public class SequenceGenerator {

	private long counter;
	
	public long nextSequence() {
		return counter++;
	}
}
