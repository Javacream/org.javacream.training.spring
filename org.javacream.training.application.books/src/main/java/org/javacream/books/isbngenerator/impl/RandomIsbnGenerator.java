package org.javacream.books.isbngenerator.impl;

import java.util.Random;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev","test"})
@ManagedResource(objectName="org.javacream:type=IsbnGenerator")
public class RandomIsbnGenerator implements IsbnGenerator {

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
	private Random random;
	
	{
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}
	
	public String next(){
		return prefix + random.nextInt() + countryCode;
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
