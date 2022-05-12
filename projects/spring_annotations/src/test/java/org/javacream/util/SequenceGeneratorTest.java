package org.javacream.util;

import org.javacream.JavacreamTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@JavacreamTest
public class SequenceGeneratorTest {

	@Autowired private SequenceGenerator sequenceGenerator;
	@Test public void sequenceGeneratorGeneratesIdsInSequence() {
		long id1 = sequenceGenerator.nextSequence();
		long id2 = sequenceGenerator.nextSequence();
		Assertions.assertEquals(1,  (id2 - id1));
	}
}