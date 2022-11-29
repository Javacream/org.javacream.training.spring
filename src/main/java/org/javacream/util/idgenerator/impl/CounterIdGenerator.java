package org.javacream.util.idgenerator.impl;

import org.javacream.util.idgenerator.api.IdGenerator;
import org.javacream.util.idgenerator.api.IdGenerator.SequenceStrategy;
import org.springframework.stereotype.Component;

@Component
@SequenceStrategy
public class CounterIdGenerator implements IdGenerator{

	private long counter;
	@Override
	public long nextId() {
		return counter++;
	}

}
