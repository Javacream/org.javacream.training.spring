package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@IsbnGenerator.SequenceStrategy
@Profile("dev")
public class CounterIsbnGenerator implements IsbnGenerator {

	@Value("${isbngenerator.prefix}") private String prefix;
	@Value("${isbngenerator.countryCode}") private String countryCode;
	private int counter;
	public String next(){
		return prefix + counter++ + countryCode;
	}

}
