package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //ComponentScan "alles darunter", Laden der application.properties
public class JavacreamApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(JavacreamApplication.class);
		app.setAdditionalProfiles("prod");
		app.run(args);
	}

}
