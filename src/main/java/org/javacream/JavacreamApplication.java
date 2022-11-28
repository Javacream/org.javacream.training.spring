package org.javacream;

import javax.annotation.PostConstruct;

import org.javacream.store.impl.SimpleStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JavacreamApplication {

	@Autowired private SimpleStoreService simpleStoreService;
	@PostConstruct public void startApp() {
		System.out.println(simpleStoreService.getStock(("Egal"), "Auch egal"));
	}
}
