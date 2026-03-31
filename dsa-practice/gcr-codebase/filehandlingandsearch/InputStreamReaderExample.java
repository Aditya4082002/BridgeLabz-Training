package filehandlingandsearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

class InputStreamReaderExample {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\Asus\\Desktop\\New folder\\BridgeLabz-training\\src\\filehandlingandsearch\\output";

        try {
            FileInputStream fis = new FileInputStream(filePath);

            // Convert byte stream to character stream using UTF-8
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            BufferedReader br = new BufferedReader(isr);

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

