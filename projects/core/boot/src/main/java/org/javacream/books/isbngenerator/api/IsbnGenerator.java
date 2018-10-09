package org.javacream.books.isbngenerator.api;

public interface IsbnGenerator {

	String RANDOM = "random";
	String SEQUENCE = "sequence";
	
	public abstract String next();
	

}