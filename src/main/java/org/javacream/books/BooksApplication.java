package org.javacream.books;

import javax.annotation.PostConstruct;

import org.javacream.store.impl.SimpleStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BooksApplication {

	@Autowired
	private SimpleStoreService storeService;
	@Autowired
	private SimpleStoreService storeService2;
	@PostConstruct
	public void doBooksApplication() {
		System.out.println("Starting Books-App");
		//...
		System.out.println(storeService.getStock("books", "ISBN1"));
		System.out.println("IDENTITY: " + (storeService == storeService2));
		System.out.println("Books-App finished");
		
	}
}
