package org.javacream.books.warehouse.test;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import org.hamcrest.text.MatchesPattern;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest(classes = BooksServiceTestConfiguration.class)
@ActiveProfiles("test")
public class BooksServiceTest {

	@Autowired
	@Qualifier("plain")
	private BooksService booksService;
	@Autowired
	@Qualifier("withCloning")
	private BooksService booksServiceWithCloning;

	private MockRestServiceServer mockRestServiceServer;
	@Autowired
	@Qualifier("forContent")
	private RestTemplate restTemplate;

	@BeforeEach
	public void setUp() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
		mockRestServiceServer.expect(ExpectedCount.once(), requestTo(MatchesPattern.matchesPattern("http://localhost:9002/api/content/.*")))
				.andExpect(method(HttpMethod.GET)).andRespond(withStatus(HttpStatus.OK)
						.contentType(MediaType.TEXT_PLAIN).body(mapper.writeValueAsString("Simple Content")));
	}

	@Test
	public void testBusinessObjects() {
		TestActor.doTest(booksService);
	}

	@Test
	public void testBusinessObjectsWithCloning() {
		TestActor.doTest(booksServiceWithCloning);
	}

	@Test
	public void testFindBookInTestData() throws BookException {
		Assertions.assertEquals("Title1", booksService.findBookByIsbn("ISBN1").getTitle());
	}

}
