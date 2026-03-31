package com.junit_testing;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {

    // Write content to a file using FileWriter
    public void writeToFile(String filename, String content) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }

    // Read content from a file using FileReader
    public String readFromFile(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        StringBuilder content = new StringBuilder();

        int ch;
        while ((ch = reader.read()) != -1) {
            content.append((char) ch);
        }
        reader.close();

        return content.toString();
    }
}
