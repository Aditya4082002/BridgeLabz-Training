package streams;

import java.io.*;
import java.util.*;

public class Top5WordFrequency {

    public static void main(String[] args) {

        String filePath = "user_info.txt";

        HashMap<String, Integer> freqMap = new HashMap<>();
        long totalWords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {

                // lowercase + remove punctuation
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", " ");

                String[] words = line.trim().split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    totalWords++;
                    freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
                }
            }

            // Convert map to list for sorting
            List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());

            // Sort by frequency (descending)
            list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            System.out.println("Total Words: " + totalWords);
            System.out.println("Top 5 Most Frequent Words:");

            int count = 0;
            for (Map.Entry<String, Integer> entry : list) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
                count++;

                if (count == 5) break;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
