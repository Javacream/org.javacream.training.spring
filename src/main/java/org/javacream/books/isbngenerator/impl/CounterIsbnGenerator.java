package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;

public class CounterIsbnGenerator implements IsbnGenerator {

	private String prefix;
	private String countryCode;
	private int counter;
	public String next(){
		return prefix + counter++ + countryCode;
	}

}
