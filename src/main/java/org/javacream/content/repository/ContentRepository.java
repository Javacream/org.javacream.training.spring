package org.javacream.content.repository;

import org.javacream.content.api.Content;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface ContentRepository extends CouchbaseRepository<Content, String>{
}
