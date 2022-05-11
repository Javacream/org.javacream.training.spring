package org.javacream.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SequenceGenerator {

	private long counter;
	
	public long nextSequence() {
		return counter++;
	}
}
