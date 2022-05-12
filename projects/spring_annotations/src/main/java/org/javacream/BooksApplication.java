package org.javacream;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksApplication {

	@Bean
	@SequenceStrategy
	public IsbnGenerator sequenceIsbnGenerator() {
		CounterIsbnGenerator counterIsbnGenerator = new CounterIsbnGenerator();
		return counterIsbnGenerator;
	}
	
}
