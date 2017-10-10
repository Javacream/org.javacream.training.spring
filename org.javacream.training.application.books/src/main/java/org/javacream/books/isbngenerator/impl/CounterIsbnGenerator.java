package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
@ManagedResource(objectName="org.javacream:type=IsbnGenerator")
public class CounterIsbnGenerator implements IsbnGenerator {

	@Value("${isbngenerator.prefix}")
	private String prefix;
	@Value("${isbngenerator.countryCode}")
	private String countryCode;
	@ManagedAttribute
	public String getCountryCode() {
		return countryCode;
	}

	@ManagedAttribute
	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}
	private int counter;
	public String next(){
		return prefix + counter++ + countryCode;
	}

	@ManagedAttribute
	public String getPrefix(){
		return prefix;
	}
	@ManagedAttribute
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
