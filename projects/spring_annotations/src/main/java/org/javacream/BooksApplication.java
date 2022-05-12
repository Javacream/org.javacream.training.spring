package org.javacream;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.javacream.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksApplication {

	@Bean
	@SequenceStrategy
	public IsbnGenerator sequenceIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix,
			@Value("${isbngenerator.countryCode}") String countryCode, SequenceGenerator sequenceGenerator) {
		CounterIsbnGenerator counterIsbnGenerator = new CounterIsbnGenerator();
		// counterIsbnGenerator.setPrefix("Hugo");
		// counterIsbnGenerator.setSequenceGenerator(new SequenceGenerator()); //MIT DAS
		// SCHLIMMSTE WAS SIE MACHEN KÖNNEN!
		counterIsbnGenerator.setPrefix(prefix);
		counterIsbnGenerator.setCountryCode(countryCode);
		counterIsbnGenerator.setSequenceGenerator(sequenceGenerator);

		return counterIsbnGenerator;
	}
}
