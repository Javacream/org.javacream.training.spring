package org.javacream.util.idgenerator.impl;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.javacream.util.idgenerator.api.IdGenerator;
import org.javacream.util.idgenerator.api.IdGenerator.RandomStrategy;
import org.springframework.stereotype.Component;

@Component
@RandomStrategy
public class RandomIdGenerator implements IdGenerator{

	private Random random;
	
	@PostConstruct public void init() {
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}
	@Override
	public long nextId() {
		return random.nextLong();
	}

}
