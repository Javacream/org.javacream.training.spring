package org.javacream.content.api;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface ContentRepository extends CouchbaseRepository<Content, String>{
}
