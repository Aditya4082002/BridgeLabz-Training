package collections;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordsFromFile(String filePath) {
        Map<String, Integer> freqMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {

                // 1) Convert to lowercase
                line = line.toLowerCase();

                // 2) Replace punctuation/special characters with space
                line = line.replaceAll("[^a-z0-9 ]", " ");

                // 3) Split into words
                String[] words = line.trim().split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return freqMap;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Asus\\Desktop\\New folder\\BridgeLabz-training\\src\\collections\\TEXT";

        Map<String, Integer> result = countWordsFromFile(filePath);

        System.out.println(result);
    }
}
