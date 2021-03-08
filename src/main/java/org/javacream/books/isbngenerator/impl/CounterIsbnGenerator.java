package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//@Service("sequenceIsbnGenerator")
@Service
@SequenceStrategy
public class CounterIsbnGenerator implements IsbnGenerator {

	@Value("${isbn.prefix}")
	private String prefix;
	@Value("${isbn.countryCode}")
	private String countryCode;
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
