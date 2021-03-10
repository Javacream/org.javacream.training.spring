package org.javacream.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.javacream")
public class ContentApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ContentApplication.class);
		app.setAdditionalProfiles("prod");
		app.run(args);
	}

}
