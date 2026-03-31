package streams;

import java.io.*;

public class PipedStreamDemo {

    public static void main(String[] args) {

        try {
            // Create piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // connect output to input

            // Writer Thread
            Thread writer = new Thread(() -> {
                try {
                    String message = "Hello from Writer Thread!";
                    pos.write(message.getBytes());
                    pos.flush(); //ensures data is pushed immediately
                    pos.close(); //close after writing
                } catch (IOException e) {
                    System.out.println("Writer IOException: " + e.getMessage());
                }
            });

            // Reader Thread
            Thread reader = new Thread(() -> {
                try {
                    int data;
                    System.out.print("Reader got: ");

                    while ((data = pis.read()) != -1) {
                        System.out.print((char) data);
                    }

                    pis.close();
                } catch (IOException e) {
                    System.out.println("Reader IOException: " + e.getMessage());
                }
            });

            // Start threads
            reader.start();
            writer.start();

            // Wait for both to finish (synchronization)
            writer.join();
            reader.join();

        } catch (IOException e) {
            System.out.println("Main IOException: " + e.getMessage());

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}

