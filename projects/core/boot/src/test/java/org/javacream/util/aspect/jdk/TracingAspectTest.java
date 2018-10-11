package org.javacream.util.aspect.jdk;



import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGeneratorService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.StoreRestServiceStub;
import org.javacream.util.aspects.jdk.TracingAspects;
import org.junit.Test;

public class TracingAspectTest {

	//@Test 
	public void testStoreServiceDecoration() {
		StoreService storeService = new StoreRestServiceStub();
		System.out.println(storeService.getClass().getName());
		System.out.println(Arrays.asList(storeService.getClass().getInterfaces()));
		storeService = TracingAspects.decorate(storeService);
		System.out.println(storeService.getStock("dies", "das"));
		System.out.println(storeService.getClass().getName());
		System.out.println(Arrays.asList(storeService.getClass().getInterfaces()));
	}

	//@Test 
	public void testIsbnGeneratorDecoration() {
		IsbnGenerator isbnGenerator = new RandomIsbnGeneratorService();
		isbnGenerator = TracingAspects.decorate(isbnGenerator);
		System.out.println(isbnGenerator.next());
		
	}
	
	@Test public void testList() {
		List<String> names = new ArrayList<>();
		names = TracingAspects.decorate(names);
		names.add("Hugo");
		names.add("Emil");
		names.add("Fritz");
		System.out.println(names.size());
		
		
	}

}
