package org.javacream.books.isbngenerator.impl;

import javax.annotation.PostConstruct;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CounterIsbnGenerator implements IsbnGenerator {

	{
		System.out.println("constructing " + this + ", prefix=" + this.prefix + ", countryCode=" + this.countryCode);
	}
	@PostConstruct public void init() {
		System.out.println("initializing " + this + ", prefix=" + this.prefix + ", countryCode=" + this.countryCode);
	}
	@Value("${isbngenerator.prefix}") private String prefix;
	@Value("${isbngenerator.countryCode}") private String countryCode;
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
