package org.javacream.util.aspects;

import java.util.ArrayList;
import java.util.List;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.util.aspects.jdk.TracingAspect;
import org.junit.Test;

public class AspectTest {

	@Test public void testStoreService() {
		StoreService storeService = new SimpleStoreService();
		storeService = TracingAspect.createProxy(storeService);
		System.out.println(storeService.getStock("Eg", "al"));
	}
	@Test public void testIsbnGenerator() {
		IsbnGenerator isbnGenerator = new  RandomIsbnGeneratorService();
		isbnGenerator = TracingAspect.createProxy(isbnGenerator);
		System.out.println(isbnGenerator.next());
	}
	
	@Test public void testList() {
		List<String> names = new ArrayList<>();
		names = TracingAspect.createProxy(names);
		names.add("Hugo");
		names.add("Emil");
		System.out.println(names.size());
		System.out.println(names);
	}


}
