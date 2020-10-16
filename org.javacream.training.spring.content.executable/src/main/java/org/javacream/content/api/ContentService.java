package org.javacream.content.api;

import java.util.List;

public interface ContentService {

	Content findById(String id);
	List<String> findByTag(String tag);
}
