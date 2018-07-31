package org.javacream.books.isbngenerator.api;

public interface IsbnGeneratorService {

	public abstract String next();

	public class Algorithms{
		public static final String RANDOM = "random";
		public static final String SEQUENCE = "sequence";
	}
}