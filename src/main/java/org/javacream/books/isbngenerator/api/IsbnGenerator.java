package org.javacream.books.isbngenerator.api;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

public interface IsbnGenerator {

	public abstract String next();

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
	@Documented
	@Qualifier
	public @interface SequenceStrategy {
	}
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
	@Documented
	@Qualifier
	public @interface RandomStrategy {
	}
}