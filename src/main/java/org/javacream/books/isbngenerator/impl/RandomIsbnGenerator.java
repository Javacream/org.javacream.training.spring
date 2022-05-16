package org.javacream.books.isbngenerator.impl;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RandomStrategy
public class RandomIsbnGenerator implements IsbnGenerator {
	@Value("${isbngenerator.prefix}")
	private String prefix;
	@Value("${isbngenerator.countryCode}")
	private String countryCode;
	
	{
		System.out.println("constructing " + this + ", prefix=" + prefix);
	}
	
	public RandomIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix, @Value("${isbngenerator.countryCode}") String countryCode) {
		this.prefix = prefix;
		this.countryCode = countryCode;
		System.out.println("constructing 2 " + this + ", prefix=" + prefix);
	}
	
	@PostConstruct public void initialize() {
		System.out.println("initializing " + this  + ", prefix=" + prefix);
		
	}
	@PreDestroy public  void remove() {
		System.out.println("destroying " + this);
		
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
