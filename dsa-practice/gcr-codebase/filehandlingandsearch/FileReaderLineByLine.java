package filehandlingandsearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileReaderLineByLine {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\Asus\\Desktop\\New folder\\BridgeLabz-training\\src\\filehandlingandsearch\\output";
        
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // closes BufferedReader + FileReader
            br.close();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
