package org.javacream;

import org.javacream.books.warehouse.api.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ImportResource("classpath:spring-beans.xml")
public class JavacreamApplication {

    @Bean @Qualifier("prefix")
    public String prefix(@Value("${isbngenerator.prefix}") String p){
        System.out.println("##################### GENERATING PREFIX " + p);
        return p;
    }

    @Bean @Qualifier("countryCode") public String countryCode(@Value("${isbngenerator.countryCode}") String cc){
        return cc;
    }

    @Bean public Map<String, Book> books(){
        HashMap<String, Book> books = new HashMap<>();
        for (int i = 1; i <= 5; i++){
            Book b = new Book();
            b.setIsbn("Isbn" + i);
            b.setTitle("Title" + i);
            b.setPrice(1.99 * i);
            books.put(b.getIsbn(), b);
        }
        return books;
    }
}
