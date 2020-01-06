package org.javacream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {
		System.out.println("************** STARTING ****************+");
		SpringApplication.run(BooksApplication.class, args);
	}

}
