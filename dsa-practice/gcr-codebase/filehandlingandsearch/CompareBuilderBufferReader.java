package filehandlingandsearch;

import java.io.*;
import java.nio.charset.StandardCharsets;

class CompareBuilderBufferReader {

    //Count words from BufferedReader
    public static long countWords(BufferedReader br) throws IOException {
        long wordCount = 0;
        String line;

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;

            // split by whitespace
            String[] words = line.trim().split("\\s+");
            wordCount += words.length;
        }
        return wordCount;
    }

    public static void main(String[] args) {

        int n = 1000000;
        String str = "hello";

        //StringBuilder Performance
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(str);
        }

        long endBuilder = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endBuilder - startBuilder) + " ns");


 
        //StringBuffer Performance
        long startBuffer = System.nanoTime();
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < n; i++) {
            buffer.append(str);
        }

        long endBuffer = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endBuffer - startBuffer) + " ns");



        //FileReader vs InputStreamReader (Word Count)

        String filePath = "C:\\Users\\Asus\\Desktop\\New folder\\BridgeLabz-training\\src\\filehandlingandsearch\\output";

        //FileReader
        try {
            long startFR = System.nanoTime();

            FileReader fr = new FileReader(filePath);
            BufferedReader br1 = new BufferedReader(fr);

            long wordsFR = countWords(br1);

            br1.close();

            long endFR = System.nanoTime();

            System.out.println("\nFileReader Word Count: " + wordsFR);
            System.out.println("FileReader Time: " + (endFR - startFR) + " ns");

        } catch (IOException e) {
            System.out.println("FileReader Error: " + e.getMessage());
        }

        //InputStreamReader
        try {
            long startISR = System.nanoTime();

            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br2 = new BufferedReader(isr);

            long wordsISR = countWords(br2);

            br2.close();

            long endISR = System.nanoTime();

            System.out.println("\nInputStreamReader Word Count: " + wordsISR);
            System.out.println("InputStreamReader Time: " + (endISR - startISR) + " ns");

        } catch (IOException e) {
            System.out.println("InputStreamReader Error: " + e.getMessage());
        }
    }
}

