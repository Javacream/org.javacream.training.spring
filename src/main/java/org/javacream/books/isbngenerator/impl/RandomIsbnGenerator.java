package org.javacream.books.isbngenerator.impl;

import java.util.Random;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@IsbnGenerator.RandomStrategy
public class RandomIsbnGenerator implements IsbnGenerator {


	@Value("${isbngenerator.prefix}") private String prefix;
	@Value("${isbngenerator.countryCode}") private String countryCode;
	private Random random;

	@PostConstruct public void init(){
		System.out.println("in post construct: " + this);
	}
	@PreDestroy
	public void rm(){
		System.out.println("in pre destroy: " + this);
	}
	{
		random = new Random(this.hashCode() + System.currentTimeMillis());
		System.out.println("in default constructor: " + this);
	}
	
	public String next(){
		return prefix + random.nextInt() + countryCode;
	}

}
