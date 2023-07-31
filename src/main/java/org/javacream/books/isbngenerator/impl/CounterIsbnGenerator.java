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

	private String prefix;
	@Value("${isbngenerator.countryCode}")
	private String countryCode;
	//Constructor Injection, Sawitzki: Mag ich nicht... (jetzt kommt es nämlich zu Problemen bei zirkularen Dependencies)
	public CounterIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix, @Value("${isbngenerator.countryCode}")String countryCode){
		System.out.println("**************** prefix in Constructor: " + prefix);
		System.out.println("**************** countryCode in Constructor: " + countryCode);
		this.prefix = prefix;
		this.countryCode = countryCode;

	}
	@PostConstruct public void initTheObject() {
		System.out.println("**************** prefix in @PostConstruct: " + prefix);
		System.out.println("**************** countryCode in @PostConstruct: " + countryCode);
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
