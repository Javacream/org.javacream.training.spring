package org.javacream.books.warehouse;

import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.books.warehouse.impl.decorator.CallByValueBooksService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BooksServiceConfiguration {

	@Bean @Primary public BooksService booksService(MapBooksService mapBooksService, CallByValueBooksService callByValueBooksService) {
		callByValueBooksService.setBooksService(mapBooksService);
		return callByValueBooksService;
		
	}

}
