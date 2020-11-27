package org.javacream.books;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BooksConfiguration {

	@Bean @Qualifier("store")
	public RestTemplate restTemplate(RestTemplateBuilder rtb) {
		return rtb.build();
	}
}
