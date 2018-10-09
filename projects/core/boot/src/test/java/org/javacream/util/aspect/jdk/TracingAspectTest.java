package org.javacream.util.aspect.jdk;



import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.util.aspects.jdk.TracingAspect;
import org.junit.Test;

public class TracingAspectTest {

	//@Test 
	public void testStoreServiceDecoration() {
		StoreService storeService = new SimpleStoreService();
		System.out.println(storeService.getClass().getName());
		System.out.println(Arrays.asList(storeService.getClass().getInterfaces()));
		storeService = TracingAspect.decorate(storeService);
		System.out.println(storeService.getStock("dies", "das"));
		System.out.println(storeService.getClass().getName());
		System.out.println(Arrays.asList(storeService.getClass().getInterfaces()));
	}

	//@Test 
	public void testIsbnGeneratorDecoration() {
		IsbnGenerator isbnGenerator = new RandomIsbnGenerator();
		isbnGenerator = TracingAspect.decorate(isbnGenerator);
		System.out.println(isbnGenerator.next());
		
	}
	
	@Test public void testList() {
		List<String> names = new ArrayList<>();
		names = TracingAspect.decorate(names);
		names.add("Hugo");
		names.add("Emil");
		names.add("Fritz");
		System.out.println(names.size());
		
		
	}

}
