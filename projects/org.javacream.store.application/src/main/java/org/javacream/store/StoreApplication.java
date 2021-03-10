package org.javacream.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(StoreApplication.class);
		app.setAdditionalProfiles("prod");
		app.run(args);
	}

}
