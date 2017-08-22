package org.javacream.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="org.javacream")
public class BooksWarehouseConfiguration {

	public static void main(String[] args) {
		new SpringApplication(BooksWarehouseConfiguration.class).run(args);
	}
}
