package org.javacream.content.web;

import java.util.Optional;

import org.javacream.content.api.Content;
import org.javacream.content.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentWebService {

	@Autowired
	private ContentRepository contentRepository;

	@GetMapping(path = "api/content/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getContent(@PathVariable("id") String resourceId) {
		Optional<Content> result = contentRepository.findById(resourceId);
		if (result.isPresent()) {
			return result.get().getData();
		} else {
			return "no content";
		}
	}
}
