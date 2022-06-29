package org.javacream.content.test;

import org.javacream.content.ContentServiceConfiguration;
import org.javacream.content.api.ContentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ContentServiceConfiguration.class)
@ActiveProfiles("test")
public class CouchbaseContentRepositoryTest {
	@Autowired
	private ContentRepository contentRepository;

	@Test
	public void testContentService() {
		Assertions.assertNotNull(contentRepository.findById("ISBN1"));
		System.out.println(contentRepository.findById("ISBN2"));
	}
}
