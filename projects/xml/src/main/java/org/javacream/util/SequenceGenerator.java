package org.javacream.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

public class SequenceGenerator {
	private long counter;
	
	public long nextInSequence() {
		return counter++;
	}

	
}
