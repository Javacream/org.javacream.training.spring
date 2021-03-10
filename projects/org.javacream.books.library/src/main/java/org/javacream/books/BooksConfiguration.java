package org.javacream.books;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BooksConfiguration {
	@Bean @Qualifier("forContent") RestTemplate restTemplateForContent(RestTemplateBuilder builder) {
		return builder.build();
	}
}
