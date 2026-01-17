package filehandlingandsearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class WordCountInFile {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\Asus\\Desktop\\New folder\\BridgeLabz-training\\src\\filehandlingandsearch\\output";
        String targetWord = "java"; // word to count

        int count = 0;

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {

                // split line into words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            br.close();

            System.out.println("Word \"" + targetWord + "\" occurred: " + count + " times");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
