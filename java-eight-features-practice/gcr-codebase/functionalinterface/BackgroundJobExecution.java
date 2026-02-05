package functionalinterface;

public class BackgroundJobExecution {

    public static void main(String[] args) {

        Runnable backgroundTask = () -> {
            System.out.println("Background job started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Background job completed");
        };

        Thread workerThread = new Thread(backgroundTask);
        workerThread.start();

        System.out.println("Main thread continues execution");
    }
}
