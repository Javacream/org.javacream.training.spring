package org.javacream.books.isbngenerator.impl;

import java.util.Random;

import org.javacream.books.isbngenerator.api.IsbnGenerator;

public class RandomIsbnGeneratorService implements IsbnGenerator {
	private String prefix;
	private String countryCode;
	
	{
		System.out.println("constructing " + this + ", prefix=" + prefix);
	}
	
	public RandomIsbnGeneratorService(String prefix, String countryCode) {
		this.prefix = prefix;
		this.countryCode = countryCode;
		System.out.println("constructing 2 " + this + ", prefix=" + prefix);
	}
	

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
}
