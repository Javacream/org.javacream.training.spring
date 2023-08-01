package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Aggregat-Annotation bestehned aus @Configuration, @ComponentScan("org.javacream"), @EnableAutoconfiguration
public class JavacreamApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(JavacreamApplication.class);
        app.setAdditionalProfiles("prod");
        app.run(args);
        System.out.println("Started App!");
    }
}
