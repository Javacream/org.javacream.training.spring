package org.javacream.content.test;

import org.javacream.content.ContentServiceConfiguration;
import org.javacream.content.api.ContentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ContentServiceConfiguration.class)
public class ContentServiceTest {
	@Autowired private ContentService contentService;
	@Test public void testContentService() {
		Assertions.assertEquals("a great book about spring", contentService.retrieveContent("ISBN1"));
	}
}
