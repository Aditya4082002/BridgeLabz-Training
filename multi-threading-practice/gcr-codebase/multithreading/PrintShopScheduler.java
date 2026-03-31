package multithreading;

class PrintJob implements Runnable {

    private String jobName;
    private int pages;
    private int priority;

    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= pages; i++) {
            System.out.println("Printing " + jobName + " - Page " + i + " of " + pages +
                    " | Thread: " + Thread.currentThread().getName());

            try {
                Thread.sleep(100);  // 100ms per page
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println(jobName + " completed in " + (endTime - startTime) + " ms");
    }

    public int getPriority() {
        return priority;
    }
}

public class PrintShopScheduler {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting print jobs...\n");

        long globalStart = System.currentTimeMillis();

        PrintJob job1 = new PrintJob("Job1", 10, 5);
        PrintJob job2 = new PrintJob("Job2", 5, 8);
        PrintJob job3 = new PrintJob("Job3", 15, 3);
        PrintJob job4 = new PrintJob("Job4", 8, 6);
        PrintJob job5 = new PrintJob("Job5", 12, 7);

        Thread t1 = new Thread(job1, "Thread-Job1");
        Thread t2 = new Thread(job2, "Thread-Job2");
        Thread t3 = new Thread(job3, "Thread-Job3");
        Thread t4 = new Thread(job4, "Thread-Job4");
        Thread t5 = new Thread(job5, "Thread-Job5");

        // Set thread priorities (1 to 10)
        t1.setPriority(job1.getPriority());
        t2.setPriority(job2.getPriority());
        t3.setPriority(job3.getPriority());
        t4.setPriority(job4.getPriority());
        t5.setPriority(job5.getPriority());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        long globalEnd = System.currentTimeMillis();

        System.out.println("\nAll jobs completed in " + (globalEnd - globalStart) + " ms");
    }
}
