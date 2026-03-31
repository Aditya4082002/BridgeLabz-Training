package streams;

import java.io.*;
import java.util.Arrays;

public class ImageToByteArrayDemo {

    //Convert image file to byte[]
    public static byte[] imageToByteArray(String imagePath) throws IOException {

        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        }
    }

    //Write byte[] back to image file using ByteArrayInputStream
    public static void byteArrayToImage(byte[] data, String outputPath) throws IOException {

        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    //Verify both files are identical (byte by byte)
    public static boolean areFilesIdentical(String file1, String file2) throws IOException {

        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {

            byte[] buffer1 = new byte[4096];
            byte[] buffer2 = new byte[4096];

            int read1, read2;

            while (true) {
                read1 = fis1.read(buffer1);
                read2 = fis2.read(buffer2);

                if (read1 != read2) return false; // different size or read count
                if (read1 == -1) return true;     // both ended => identical

                if (!Arrays.equals(Arrays.copyOf(buffer1, read1), Arrays.copyOf(buffer2, read2))) {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {

        String inputImage = "original.jpg";
        String outputImage = "copy.jpg";

        try {
            //Image -> byte[]
            byte[] imageBytes = imageToByteArray(inputImage);

            //byte[] -> new image
            byteArrayToImage(imageBytes, outputImage);

            //Verify
            boolean same = areFilesIdentical(inputImage, outputImage);

            if (same) {
                System.out.println("Success! The new image is identical to the original.");
            } else {
                System.out.println("Files are NOT identical.");
            }

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
