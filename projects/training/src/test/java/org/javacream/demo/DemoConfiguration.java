package org.javacream.demo;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

	//@Value("${message}") private String message;
	@Bean public Demo demo(@Value("${message}") String message, SequenceGenerator sg) {
		Demo d = new Demo();
		d.setMessage(message);
		d.setSg(sg);
		return d;
	}
	
	@Bean @RandomStrategy public IsbnGenerator ig(RandomIsbnGenerator rg) {
		return rg;
	}

	
}
