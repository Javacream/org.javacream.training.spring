package org.javacream.books;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "org.javacream")
@EnableSwagger2
public class BooksWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksWebServiceApplication.class, args);
		
	}
	
	@Bean public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}
	
	
	@Bean @Qualifier("content")
	public RestTemplate restTemplateForContent(RestTemplateBuilder rtb) {
		return rtb.build();
	}

}
