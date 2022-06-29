package org.javacream.content.impl;

import org.javacream.content.api.ContentService;
import org.springframework.stereotype.Service;

@Service
public class SimpleContentService implements ContentService {

	@Override
	public String getContent(String isbn) {
		return "Hugo";
	}


}
