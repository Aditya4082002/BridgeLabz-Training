package multithreading;

import java.util.Random;

class FileDownloaderThread extends Thread {

    private String fileName;
    private Random random = new Random();

    public FileDownloaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for (int progress = 0; progress <= 100; progress += 10) {
            System.out.println("[" + Thread.currentThread().getName() + "] Downloading "
                    + fileName + ": " + progress + "%");
            try {
                Thread.sleep(random.nextInt(300) + 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class FileDownloaderRunnable implements Runnable {

    private String fileName;
    private Random random = new Random();

    public FileDownloaderRunnable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for (int progress = 0; progress <= 100; progress += 10) {
            System.out.println("[" + Thread.currentThread().getName() + "] Downloading "
                    + fileName + ": " + progress + "%");
            try {
                Thread.sleep(random.nextInt(300) + 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class DownloadManager {

    public static void main(String[] args) throws InterruptedException {

        // Thread class approach
        FileDownloaderThread t1 = new FileDownloaderThread("Document.pdf");
        FileDownloaderThread t2 = new FileDownloaderThread("Image.jpg");
        FileDownloaderThread t3 = new FileDownloaderThread("Video.mp4");

        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads to finish
        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!");

        System.out.println("\nNow running using Runnable approach...\n");

        // Runnable approach
        Thread r1 = new Thread(new FileDownloaderRunnable("Document.pdf"));
        Thread r2 = new Thread(new FileDownloaderRunnable("Image.jpg"));
        Thread r3 = new Thread(new FileDownloaderRunnable("Video.mp4"));

        r1.start();
        r2.start();
        r3.start();

        r1.join();
        r2.join();
        r3.join();

        System.out.println("All downloads complete!");
    }
}
