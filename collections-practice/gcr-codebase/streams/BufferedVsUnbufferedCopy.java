package streams;

import java.io.*;

public class BufferedVsUnbufferedCopy {

    private static final int BUFFER_SIZE = 4096; // 4KB

    //Unbuffered Copy
    public static long copyUnbuffered(String source, String destination) throws IOException {
        long start = System.nanoTime();

        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(destination);

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;

        while ((bytesRead = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        fis.close();
        fos.close();

        long end = System.nanoTime();
        return end - start;
    }

    //Buffered Copy
    public static long copyBuffered(String source, String destination) throws IOException {
        long start = System.nanoTime();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination));

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;

        while ((bytesRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bis.close();
        bos.close();

        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {

        String sourceFile = "bigfile.dat";
        String unbufferedCopyFile = "copy_unbuffered.dat";
        String bufferedCopyFile = "copy_buffered.dat";

        try {
            File src = new File(sourceFile);

            if (!src.exists()) {
                System.out.println("Source file not found: " + sourceFile);
                return;
            }

            long timeUnbuffered = copyUnbuffered(sourceFile, unbufferedCopyFile);
            long timeBuffered = copyBuffered(sourceFile, bufferedCopyFile);

            System.out.println("---- Copy Performance Comparison ----");
            System.out.println("Unbuffered Time : " + (timeUnbuffered / 1_000_000.0) + " ms");
            System.out.println("Buffered Time   : " + (timeBuffered / 1_000_000.0) + " ms");

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}

