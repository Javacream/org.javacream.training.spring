package org.javacream;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApplicationConfiguration {

	@Bean @Qualifier("store")
	public RestTemplate restTemplate(RestTemplateBuilder rtb) {
		return rtb.build();
	}
}
