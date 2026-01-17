package filehandlingandsearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;

class ConsoleToFile {

    public static void main(String[] args) {

    	// file where input will be saved
        String filePath = "C:\\Users\\Asus\\Desktop\\New folder\\BridgeLabz-training\\src\\filehandlingandsearch\\output";

        try {
            // Read input from console
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            // Write to file
            FileWriter fw = new FileWriter(filePath, true); // true = append mode

            System.out.println("Enter text (type 'exit' to stop):");

            String input;

            while (true) {
                input = br.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                fw.write(input + "\n");  // write each input on new line
            }

            fw.close();
            System.out.println("Data saved successfully in " + filePath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
