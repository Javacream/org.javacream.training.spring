package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@SequenceStrategy
public class CounterIsbnGenerator implements IsbnGenerator {

	private String prefix;
	private String countryCode;
	private int counter;
	public String next(){
		return prefix + counter++ + countryCode;
	}

}
