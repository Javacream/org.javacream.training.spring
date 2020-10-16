package org.javacream.content.web;

import java.util.List;

import org.javacream.content.api.Content;
import org.javacream.content.api.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/content")
public class ContentWebService {

	@Autowired private ContentService contentService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "{id}")
	public Content findById(@PathVariable("id") String id) {
		return contentService.findById(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "tags/{tag}")
	public List<String> findByTag(@PathVariable("tag") String tag) {
		return contentService.findByTag(tag);
	}
}
