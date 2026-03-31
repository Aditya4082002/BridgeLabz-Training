package RuntimeAnalysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class FileReaderVsInputStreamReader {

    // FileReader (Character Stream)
    public static long readUsingFileReader(String filePath) throws Exception {
        long start = System.nanoTime();

        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        while (br.readLine() != null) {
            // reading file line by line
        }

        br.close();

        long end = System.nanoTime();
        return (end - start);
    }

    // InputStreamReader
    public static long readUsingInputStreamReader(String filePath) throws Exception {
        long start = System.nanoTime();

        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        while (br.readLine() != null) {
            // reading file line by line
        }

        br.close();

        long end = System.nanoTime();
        return (end - start);
    }

    public static void main(String[] args) {

        // Put your file path here
        String filePath = "C:\\\\Users\\\\Asus\\\\Desktop\\\\New folder\\\\BridgeLabz-training\\\\src\\\\RuntimeAnalysis\\\\largeFile";  // Example path

        try {
            System.out.println("=======================================");
            System.out.println("Comparing FileReader vs InputStreamReader");
            System.out.println("File Path: " + filePath);
            System.out.println("=======================================");

            long fileReaderTime = readUsingFileReader(filePath);
            System.out.println("FileReader Time         : " + fileReaderTime + " ns");

            long inputStreamReaderTime = readUsingInputStreamReader(filePath);
            System.out.println("InputStreamReader Time  : " + inputStreamReaderTime + " ns");

            System.out.println("=======================================");

            if (inputStreamReaderTime < fileReaderTime) {
                System.out.println("InputStreamReader is faster for large files.");
            } else {
                System.out.println("FileReader is better for this case.");
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
