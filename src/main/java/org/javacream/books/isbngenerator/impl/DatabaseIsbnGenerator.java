package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@IsbnGenerator.SequenceStrategy
@Profile("prod")
public class DatabaseIsbnGenerator implements IsbnGenerator {

	public String next(){
		return "TO BE IMPLEMENTED";
	}

}
