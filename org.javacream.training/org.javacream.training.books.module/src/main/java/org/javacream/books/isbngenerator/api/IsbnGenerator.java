package org.javacream.books.isbngenerator.api;

public interface IsbnGenerator {

	public abstract String next();
	
	interface Strategy{
		public static final String RANDOM = "random";
		public static final String SEQUENCE = "sequence";
	}

}