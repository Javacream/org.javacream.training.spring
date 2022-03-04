package org.javacream.util;

import org.springframework.stereotype.Service;

@Service
public class SequenceIdGenerator {

	private long counter = 0;
	public Long next() {
		return counter++;
	}
}
