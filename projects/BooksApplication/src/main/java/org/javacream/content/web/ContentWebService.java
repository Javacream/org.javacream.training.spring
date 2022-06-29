package org.javacream.content.web;

import org.javacream.content.api.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentWebService {

	@Autowired private ContentService contentService;
	@GetMapping(path="api/content/{isbn}", produces=MediaType.TEXT_PLAIN_VALUE ) public String getContent(@PathVariable("isbn") String isbn) {
		return contentService.getContent(isbn);
	}
}
