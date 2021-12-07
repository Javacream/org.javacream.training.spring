package org.javacream;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.books.isbngenerator.api.IsbnGeneratorService.SimpleRandomStrategy;
import org.javacream.books.isbngenerator.impl.MathRandomIsbnGeneratorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
 * Eine Configuration macht Dependency Outjection (kein Standard Begriff)
 */
@Configuration
@Profile("prod")
public class ApplicationConfiguration {

	@Bean
	@SimpleRandomStrategy
	public IsbnGeneratorService simpleIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix,
			@Value("${isbngenerator.countryCode}") String countryCode

	) {
		MathRandomIsbnGeneratorService isbnGenerator = new MathRandomIsbnGeneratorService();
		isbnGenerator.setPrefix(prefix);
		isbnGenerator.setCountryCode(countryCode);
		return isbnGenerator;
	}

	
}
