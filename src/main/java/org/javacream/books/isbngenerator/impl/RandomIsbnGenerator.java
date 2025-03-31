package org.javacream.books.isbngenerator.impl;

import java.util.Random;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RandomIsbnGenerator implements IsbnGenerator {

	private String prefix;
	private String countryCode;
	private Random random;
	
	{
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}

	public RandomIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix, @Value("${isbngenerator.countryCode}") String countryCode) {
		this.prefix = prefix;
		this.countryCode = countryCode;
	}

	@PostConstruct
	public void initRig(){
		System.out.println("initializing " + this);
	}
	@PreDestroy
	public void finalizeRig(){
		System.out.println("initializing " + this);
	}

	public String next(){
		return prefix + random.nextInt() + countryCode;
	}

}
