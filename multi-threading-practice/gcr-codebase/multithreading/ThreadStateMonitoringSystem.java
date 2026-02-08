package multithreading;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {

        try {
            // Simulate computation
            for (int i = 0; i < 5; i++) {
                double result = Math.sqrt(i * 1000);
            }

            // Move to TIMED_WAITING
            Thread.sleep(2000);

            // More computation
            for (int i = 0; i < 5; i++) {
                double result = Math.pow(i, 2);
            }

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
        }
    }
}

class StateMonitor extends Thread {

    private List<Thread> threads;
    private Map<String, Set<Thread.State>> stateHistory = new HashMap<>();

    public StateMonitor(List<Thread> threads) {
        this.threads = threads;
    }

    @Override
    public void run() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        boolean allTerminated = false;

        while (!allTerminated) {

            allTerminated = true;

            for (Thread t : threads) {

                Thread.State state = t.getState();
                String time = LocalTime.now().format(formatter);

                stateHistory
                        .computeIfAbsent(t.getName(), k -> new HashSet<>())
                        .add(state);

                System.out.println("[Monitor] " + t.getName() +
                        " is in " + state +
                        " state at " + time);

                if (state != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted.");
            }
        }

        printSummary();
    }

    private void printSummary() {
        System.out.println("\nSummary of state changes:");

        for (Map.Entry<String, Set<Thread.State>> entry : stateHistory.entrySet()) {
            System.out.println(entry.getKey() +
                    " went through " +
                    entry.getValue().size() +
                    " states: " +
                    entry.getValue());
        }
    }
}

public class ThreadStateMonitoringSystem {

    public static void main(String[] args) throws InterruptedException {

        TaskRunner task1 = new TaskRunner("Task-1");
        TaskRunner task2 = new TaskRunner("Task-2");

        List<Thread> taskList = Arrays.asList(task1, task2);

        StateMonitor monitor = new StateMonitor(taskList);

        // Initially threads are NEW
        monitor.start();

        Thread.sleep(500);

        task1.start();
        task2.start();

        task1.join();
        task2.join();
        monitor.join();

        System.out.println("\nAll tasks completed.");
    }
}

