package org.javacream.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")

public class SequenceGeneratorTest {

	@Autowired private SequenceGenerator sequenceGenerator;
	@Test public void sequenceGeneratorGeneratesIdsInSequence() {
		long id1 = sequenceGenerator.nextInSequence();
		long id2 = sequenceGenerator.nextInSequence();
		Assertions.assertEquals(1,  (id2 - id1));
	}
}
