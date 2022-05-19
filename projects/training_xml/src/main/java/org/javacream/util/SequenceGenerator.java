package org.javacream.util;

public class SequenceGenerator {
	private long counter;
	
	public long nextInSequence() {
		return counter++;
	}

	
}
