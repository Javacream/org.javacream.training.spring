package org.javacream.books.warehouse.api;

import org.javacream.books.warehouse.decorators.CloningBooksServiceDecorator;
import org.javacream.books.warehouse.impl.DatabaseBooksService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BooksServiceConfiguration {
	@Bean @Qualifier("withCloning") public BooksService booksServiceWithCloning(DatabaseBooksService mapBooksService) {
		CloningBooksServiceDecorator cloningBooksServiceDecorator = new CloningBooksServiceDecorator();
		cloningBooksServiceDecorator.setBooksService(mapBooksService);
		return cloningBooksServiceDecorator;
	}
	@Bean @Qualifier("plain") public BooksService booksService(DatabaseBooksService mapBooksService) {
		return mapBooksService;
	}
}
