package org.javacream.content;

import org.javacream.content.api.ContentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ContentServiceTest {

	private static final String VALID_ID = "SpringInAction";
	private static final String INVALID_ID = "5&6%%";
	private static final String VALID_TAG = "Java";
	private static final String INVALID_TAG = ".NET";

	@Autowired
	private ContentService contentService;

	@Test
	public void contextLoads() {

	}

	@Test
	public void validResourceIdIsFound() {
		Assertions.assertNotNull(contentService.findById(VALID_ID));
		System.out.println(contentService.findById(VALID_ID));

	}

	@Test
	public void validTagIsFound() {
		System.out.println("***** " + contentService.findByTag(VALID_TAG));
		Assertions.assertTrue(contentService.findByTag(VALID_TAG).size() > 0);

	}

	@Test
	public void invalidTagIsNotFound() {
		Assertions.assertTrue(contentService.findByTag(INVALID_TAG).size() == 0);

	}

	@Test
	public void nullTagThrowsIllegalArgumentException() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> contentService.findByTag(null));

	}

	@Test
	public void invalidResourceIdThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> contentService.findById(INVALID_ID));

	}

	@Test
	public void nullThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> contentService.findById(null));

	}

}

@Configuration
class ContentServiceTestConfiguration {

}
