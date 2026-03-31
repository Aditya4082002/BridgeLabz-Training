package streams;

import java.io.*;

public class FileCopyStreamDemo {

    public static void main(String[] args) {

        String sourceFile = "C:\\Users\\Asus\\Desktop\\New folder\\BridgeLabz-training\\src\\streams\\source";
        String destinationFile = "copy.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File src = new File(sourceFile);

            //Check if source file exists
            if (!src.exists()) {
                System.out.println("Source file does not exist: " + sourceFile);
                return;
            }

            fis = new FileInputStream(src);
            fos = new FileOutputStream(destinationFile);

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully to: " + destinationFile);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());

        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing files: " + e.getMessage());
            }
        }
    }
}
