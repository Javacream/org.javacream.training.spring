package org.javacream.content.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.javacream.content.api.Content;
import org.javacream.content.api.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouchbaseContentService implements ContentService {

	@Autowired private ContentRepository contentRepository;
	@Override
	public Content findById(String id) {
		Optional<Content> optionalContent = contentRepository.findById(id);
		if (optionalContent.isPresent()){
			return optionalContent.get();
		}else {
			throw new IllegalArgumentException("not found: " + id);
		}
	}

	@Override
	public List<String> findByTag(String tag) {
		if (tag == null) {
			throw new IllegalArgumentException("tag was null");
		}
		return contentRepository.findByTags(tag).stream().filter(content -> content.getTags().contains(tag)).map(content -> content.getId()).collect(Collectors.toList());
	}

}
