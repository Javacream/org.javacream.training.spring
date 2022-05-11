package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.javacream.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@SequenceStrategy
public class CounterIsbnGenerator implements IsbnGenerator {
	@Autowired private SequenceGenerator sequenceGenerator;
	@Value("${isbngenerator.prefix}") private String prefix;
	@Value("${isbngenerator.countryCode}") private String countryCode;
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}
	public String next(){
		return prefix + sequenceGenerator.nextSequence() + countryCode;
	}

	public String getPrefix(){
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
