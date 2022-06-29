package org.javacream.books;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.javacream.store")
@ComponentScan("org.javacream.books")
public class BooksConfiguration {

}
