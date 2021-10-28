package org.javacream.books.isbngenerator.impl;

import java.util.Random;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.RandomStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RandomStrategy
public class RandomIsbnGeneratorService implements IsbnGeneratorService {
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
}
