package com.junit_testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    FileProcessor fileProcessor = new FileProcessor();
    String filename = "testfile.txt";
    String content = "JUnit FileReader FileWriter Test";

    // Cleanup after each test
    @AfterEach
    void cleanUp() {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }

    //Test writing and reading content
    @Test
    void testWriteAndReadFile() throws IOException {
        fileProcessor.writeToFile(filename, content);
        String result = fileProcessor.readFromFile(filename);

        assertEquals(content, result);
    }

    //Test file existence after writing
    @Test
    void testFileExistsAfterWrite() throws IOException {
        fileProcessor.writeToFile(filename, content);

        File file = new File(filename);
        assertTrue(file.exists());
    }

    //Test exception when file does not exist
    @Test
    void testReadFileNotFound() {
        assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("missing.txt");
        });
    }
}
