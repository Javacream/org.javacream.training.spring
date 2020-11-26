package org.javacream.content;

import org.javacream.content.api.ContentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
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
		Assert.assertNotNull(contentService.findById(VALID_ID));
		System.out.println(contentService.findById(VALID_ID));

	}
	@Test
	public void validTagIsFound() {
		System.out.println("***** " + contentService.findByTag(VALID_TAG));
		Assert.assertTrue(contentService.findByTag(VALID_TAG).size() > 0);

	}
	@Test
	public void invalidTagIsNotFound() {
		Assert.assertTrue(contentService.findByTag(INVALID_TAG).size() == 0);

	}
	@Test (expected = IllegalArgumentException.class)
	public void nullTagThrowsIllegalArgumentException() {
		contentService.findByTag(null);

	}
	@Test (expected = IllegalArgumentException.class)
	public void invalidResourceIdThrowsIllegalArgumentException() {
		contentService.findById(INVALID_ID);

	}
	@Test (expected = IllegalArgumentException.class)
	public void nullThrowsIllegalArgumentException() {
		contentService.findById(null);

	}


}
@Configuration
class ContentServiceTestConfiguration {

}
