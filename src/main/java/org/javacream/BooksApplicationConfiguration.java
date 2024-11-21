package org.javacream;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.CounterIsbnGenerator;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.decorators.AuditingStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BooksApplicationConfiguration {

    @Bean @IsbnGenerator.SequenceStrategy public IsbnGenerator countersbnGenerator(){
        return new CounterIsbnGenerator();
    }

    @Bean @Primary public StoreService storeService(StoreService storeService){
        AuditingStoreService auditingStoreService = new AuditingStoreService();
        auditingStoreService.setStoreService(storeService);
        return auditingStoreService;
    }

    @Bean @Primary  public BooksService bs(MapBooksService mapBooksService){
        try {
            System.out.println(mapBooksService.newBook("Spring"));
            System.out.println(mapBooksService.newBook("Java"));

        } catch (BookException e) {
            throw new RuntimeException(e);
        }
        return mapBooksService;

    }
}
