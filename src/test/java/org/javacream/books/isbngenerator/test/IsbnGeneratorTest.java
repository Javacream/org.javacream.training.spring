package org.javacream.books.isbngenerator.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@ActiveProfiles("dev")
public class IsbnGeneratorTest {
//	//Funktioniert, falls im Context exakt eine implentierende Klasse zur Schnittstelle IsbnGenerator exisitiert
//	@Autowired private IsbnGenerator isbnGenerator1;
//	@Autowired private IsbnGenerator isbnGenerator2;

//	//Funktioniert, da im Context nur ein random&CounterIsbnGenerator existiert
//	@Autowired private RandomIsbnGenerator isbnGenerator1;
//	@Autowired private CounterIsbnGenerator isbnGenerator2;

////	//Funktioniert, falls Beans mit dem Namen hugo und randomIsbnGenerator existieren 
//	@Autowired private IsbnGenerator hugo;
//	@Autowired private IsbnGenerator randomIsbnGenerator;

	@Autowired @Qualifier("randomStrategy") private IsbnGenerator isbnGenerator1;
	@Autowired @Qualifier("sequenceStrategy") private IsbnGenerator isbnGenerator2;
	
	//private IsbnGenerator isbnGenerator3 = new RandomIsbnGenerator();//VORSICHT: DAS IST IN EINER SPRING-ANWENDUNG FALSCH
	
	@Test public void testGenerators() {
		System.out.println(isbnGenerator1);
		System.out.println(isbnGenerator2);

	}
	
}
