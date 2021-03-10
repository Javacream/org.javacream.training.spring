package org.javacream.content.impl;

import javax.persistence.EntityManager;

import org.javacream.content.api.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseContentService implements ContentService {
	@Autowired
	private EntityManager entityManager;

	@Override
	public String retrieveContent(String resourceId) {
		try {
			return (String) entityManager
					.createNativeQuery("select content from content where resourceId='" + resourceId + "'")
					.getSingleResult();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return "empty content";
		}
	}

}
