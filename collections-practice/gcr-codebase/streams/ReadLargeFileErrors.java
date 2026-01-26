package streams;

import java.io.*;

public class ReadLargeFileErrors {

    public static void main(String[] args) {

        String filePath = "largefile.txt"; // change this to your file name

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {

                // case-insensitive check
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}

