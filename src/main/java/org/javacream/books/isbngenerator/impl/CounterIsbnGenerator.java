package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@IsbnGenerator.SequenceStrategy
public class CounterIsbnGenerator implements IsbnGenerator {

	private String prefix;
	private String countryCode;
	public CounterIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix, @Value("${isbngenerator.countryCode}")String countryCode){
		this.prefix = prefix;
		this.countryCode = countryCode;

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
