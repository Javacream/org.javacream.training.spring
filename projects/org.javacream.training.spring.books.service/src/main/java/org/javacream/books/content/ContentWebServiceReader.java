package org.javacream.books.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ContentWebServiceReader {

	@Autowired
	@Qualifier("content")
	private RestTemplate restTemplate;

	public String getContentForIsbn(String isbn) {
		return restTemplate.getForObject("http://localhost:8083/api/content/" + isbn, String.class);

	}
}