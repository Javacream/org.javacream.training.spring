package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksConfiguration {


    public static void main(String[] args) {
        var app = new SpringApplication(BooksConfiguration.class);
        app.setAdditionalProfiles("prod");
        app.run(args);
    }
}
