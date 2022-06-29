package org.javacream.content.test;

import org.javacream.content.api.ContentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ContentTest {

	@Autowired private ContentService contentService;
	
	@Test public void testContent() {
		Assertions.assertEquals("Hugo", contentService.getContent("ISBN1"));
	}
}
