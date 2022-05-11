package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.api.IsbnGenerator.RandomStrategy;
import org.javacream.books.isbngenerator.api.IsbnGenerator.SequenceStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@ActiveProfiles("test")
public class InjectionTest {
//	//Fehler: CounterIsbnGenerator + RandomIsbnGenerator
//	@Autowired private IsbnGenerator isbnGenerator1;
//	@Autowired private IsbnGenerator isbnGenerator2;

//	//OK, hier ist durch den konkreten Typen die Auflösung wieder eindeutig
//	//Problem: Im technischen Modell sollte man sich aber doch auf ein Interface beziehen...
//	@Autowired private RandomIsbnGenerator isbnGenerator1;
//	@Autowired private CounterIsbnGenerator isbnGenerator2;

//	//Funktioniert, falls eine der IsbnGenerators @Primary ist
//	@Autowired private IsbnGenerator isbnGenerator1;
//	@Autowired private IsbnGenerator isbnGenerator2;
	
//	//Funktioniert, falls exakt ein IsbnGenerator im aktiven Profile gefunden wird
//	@Autowired private IsbnGenerator isbnGenerator1;
//	@Autowired private IsbnGenerator isbnGenerator2;

//	//Funktioniert, falls RandomIsbnGenrator @Service, CounterIsbnGenerator @Service ("isbnGenerator2")
//	@Autowired private IsbnGenerator randomIsbnGenerator;
//	@Autowired private IsbnGenerator isbnGenerator2;
	//Funktioniert, aber Zeichenketten...
//	@Autowired @Qualifier("randomStrategy") private IsbnGenerator isbnGenerator1;
//	@Autowired @Qualifier("sequenceStrategy") private IsbnGenerator isbnGenerator2;

	@Autowired @RandomStrategy private IsbnGenerator isbnGenerator1;
	@Autowired @SequenceStrategy private IsbnGenerator isbnGenerator2;
	
	@Test 
	public void showInjection() {
		System.out.println("isbnGenerator1=" + isbnGenerator1);
		System.out.println("isbnGenerator2=" + isbnGenerator2);
	}
	
}
