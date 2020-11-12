package org.javacream;

import javax.annotation.PostConstruct;

import org.javacream.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private @Autowired StoreService storeService;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	
	public @PostConstruct void run() {
		System.out.println("Application started");
		System.out.println(storeService.getStock("category", "item"));
	}

}
