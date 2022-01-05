package org.javacream.training;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringTokenizer;

public class FileReaderTest {
    @Test public void readFile() throws Exception {
        Path path = FileSystems.getDefault().getPath("people.txt");
        Files.lines(path).map(s -> {
            StringTokenizer st = new StringTokenizer(s, ",");
            String firstname = st.nextToken();
            String lastname = st.nextToken();
            return new Person(lastname, firstname);
        }).forEach(person -> System.out.println(person.info()));
    }
}
