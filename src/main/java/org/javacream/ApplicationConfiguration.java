package org.javacream;

import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.books.warehouse.impl.decorators.CloningBooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.store.impl.decorators.AuditingStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	@Bean public BooksService booksService(MapBooksService booksService) {
		CloningBooksService cbs = new CloningBooksService();
		cbs.setDelegate(booksService);
		return cbs;
	}

	@Bean public StoreService storeService(SimpleStoreService storeService) {
		AuditingStoreService ass = new AuditingStoreService();
		ass.setDelegate(storeService);
		return ass;
	}


	
}
