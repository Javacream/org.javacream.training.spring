package org.javacream.books.isbngenerator.impl;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.javacream.books.isbngenerator.api.IsbnGenerator;

public class RandomIsbnGeneratorService implements IsbnGenerator {

	
	private String prefix;
	private String countryCode;
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}
	private Random random;
	
	{
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}
	
	public String next(){
		return prefix + random.nextInt() + countryCode;
	}

	public String getPrefix(){
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	{
		System.out.println("constructor initializing " + this);
	}
	
	@PostConstruct
	public void initGenerator() {
		System.out.println("initializing " + this);
	}
	
	@PreDestroy
	public void destroyGenerator() {
		System.out.println("destroying " + this);
	}

	@Override
	public String toString() {
		return "RandomIsbnGenerator [prefix=" + prefix + ", countryCode=" + countryCode + ", random=" + random + "]";
	}
}
