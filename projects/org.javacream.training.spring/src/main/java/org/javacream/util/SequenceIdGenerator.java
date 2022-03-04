package org.javacream.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class SequenceIdGenerator {

	private long counter = 0;
	public Long next() {
		return counter++;
	}
}
