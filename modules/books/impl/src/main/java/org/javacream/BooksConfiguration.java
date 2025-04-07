package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BooksConfiguration {


    public static void main(String[] args) {
        var app = new SpringApplication(BooksConfiguration.class);
        app.setAdditionalProfiles("prod");
        app.run(args);
    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder rtb) {
        return rtb.build();
    }
}
