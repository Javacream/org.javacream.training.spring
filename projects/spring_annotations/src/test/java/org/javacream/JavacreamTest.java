package org.javacream;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Retention(RUNTIME)
@Target(TYPE)
@SpringBootTest
@ActiveProfiles("test")
public @interface JavacreamTest {

}
