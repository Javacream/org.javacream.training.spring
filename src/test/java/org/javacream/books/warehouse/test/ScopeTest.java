package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class ScopeTest {

	@Autowired private IsbnGenerator isbnGenerator1;
	@Autowired private IsbnGenerator isbnGenerator2;
	
	@Test public void showScope() {
		System.out.println("isbnGenerator1=" + isbnGenerator1);
		System.out.println("isbnGenerator2=" + isbnGenerator2);
		System.out.println(isbnGenerator1 == isbnGenerator2);
	}
	
}
