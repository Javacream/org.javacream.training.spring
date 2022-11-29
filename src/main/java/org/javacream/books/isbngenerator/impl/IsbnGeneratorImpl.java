package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.util.idgenerator.api.IdGenerator;
import org.javacream.util.idgenerator.api.IdGenerator.SequenceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IsbnGeneratorImpl implements IsbnGenerator {


	@Value("${isbngenerator.prefix}")
	private String prefix;
	@Value("${isbngenerator.countryCode}")
	private String countryCode;

	@Autowired @SequenceStrategy private IdGenerator idGenerator;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}

	public String next(){
		return prefix + idGenerator.nextId() + countryCode;
	}

	public String getPrefix(){
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
