package org.javacream.books.isbngenerator.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

public interface IsbnGenerator {

	public abstract String next();
	

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
	@Qualifier
	public @interface RandomStrategy{
		
	}
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
	@Qualifier
	public @interface SequenceStrategy{
		
	}}