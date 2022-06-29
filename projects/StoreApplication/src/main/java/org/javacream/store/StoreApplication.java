package org.javacream.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //ComponentScan "alles darunter", Laden der application.properties
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(StoreApplication.class);
		app.setAdditionalProfiles("prod");
		app.run(args);
	}

}
