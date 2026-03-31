package streams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UpperToLowerFileCopy {

    public static void main(String[] args) {

        String sourceFile = "user_info.txt";
        String destinationFile = "output.txt";

        try (
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(sourceFile), StandardCharsets.UTF_8)
            );

            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(destinationFile), StandardCharsets.UTF_8)
            )
        ) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());  // convert uppercase -> lowercase
                bw.newLine();                  // keep line breaks
            }

            System.out.println("File converted to lowercase successfully: " + destinationFile);

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
