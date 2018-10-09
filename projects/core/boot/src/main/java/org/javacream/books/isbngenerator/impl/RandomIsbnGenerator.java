package org.javacream.books.isbngenerator.impl;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Qualifier(IsbnGenerator.RANDOM)
public class RandomIsbnGenerator implements IsbnGenerator {

	
	@Value("${isbngenerator.prefix}")
	private String prefix;
	@Value("${isbngenerator.countryCode}")
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
