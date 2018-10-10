package org.javacream.books.isbngenerator.api;

import org.javacream.books.isbngenerator.impl.DatabaseSequenceIsbnGeneratorService;
import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IsbnGeneratorConfiguration {

	@Bean @Qualifier(IsbnGenerator.RANDOM) IsbnGenerator randomIsbnGenerator(@Value("isbngenerator.prefix") String prefix, @Value("isbngenerator.countryCode") String countryCode){
		RandomIsbnGeneratorService isbnGenerator = new RandomIsbnGeneratorService();
		isbnGenerator.setPrefix(prefix);
		isbnGenerator.setCountryCode(countryCode);
		return isbnGenerator;
	}
	@Bean @Qualifier(IsbnGenerator.SEQUENCE) IsbnGenerator sequenceIsbnGenerator(@Value("isbngenerator.prefix") String prefix, @Value("isbngenerator.countryCode") String countryCode){
		DatabaseSequenceIsbnGeneratorService isbnGenerator = new DatabaseSequenceIsbnGeneratorService();
		isbnGenerator.setPrefix(prefix);
		isbnGenerator.setCountryCode(countryCode);
		return isbnGenerator;
	}
}
