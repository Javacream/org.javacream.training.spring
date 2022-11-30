package org.javacream;

import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.DatabaseBooksService;
import org.javacream.books.warehouse.impl.decorators.CloningBooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.DatabaseStoreService;
import org.javacream.store.impl.decorators.AuditingStoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	@Bean public BooksService booksService(DatabaseBooksService booksService) {
		CloningBooksService cbs = new CloningBooksService();
		cbs.setDelegate(booksService);
		return cbs;
	}

	@Bean public StoreService storeService(DatabaseStoreService storeService) {
		AuditingStoreService ass = new AuditingStoreService();
		ass.setDelegate(storeService);
		return ass;
	}


	
}
