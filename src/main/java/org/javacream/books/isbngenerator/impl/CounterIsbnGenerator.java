package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Service("counterIsbnGenerator")
@Service
//@Scope("prototype")
@IsbnGenerator.SequenceStrategy
public class CounterIsbnGenerator implements IsbnGenerator {

	@Value("${isbngenerator.prefix}")
	private String prefix;
	@Value("${isbngenerator.countryCode}")
	private String countryCode;
	//Konstruktor-Aufruf erfolgt VOR der Dependency Injection
	{
		System.out.println("**************** prefix in Constructor: " + prefix);
	}
	@PostConstruct public void initTheObject() {
		System.out.println("**************** prefix in @PostConstruct: " + prefix);
	}

	@PreDestroy public void destroyIt(){
		System.out.println("**************** destroying " + this);
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}
	private int counter;
	public String next(){
		return prefix + counter++ + countryCode;
	}

	public String getPrefix(){
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
