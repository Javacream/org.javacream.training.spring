package org.javacream.books.isbngenerator.api;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface IsbnGeneratorService {

	public abstract String next();

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
	@Qualifier
	public @interface RandomStrategy {
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
	@Qualifier
	public @interface SequenceStrategy {
	}
}