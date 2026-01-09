package linkedList;

// Node class
class ProcessNode {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;
    ProcessNode next;

    public ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

// Circular Linked List for Round Robin
class RoundRobinScheduler {
    ProcessNode head = null;
    ProcessNode tail = null;
    int timeQuantum;
    int currentTime = 0;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // add process at end
    public void addProcess(int pid, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burstTime, priority);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            return;
        }

        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    // execute round robin scheduling
    public void execute() {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }

        ProcessNode current = head;

        while (head != null) {

            if (current.remainingTime > 0) {

                int executionTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= executionTime;
                currentTime += executionTime;

                System.out.println("Process " + current.pid +
                        " executed for " + executionTime +
                        " units. Remaining: " + current.remainingTime);

                // if process completed
                if (current.remainingTime == 0) {
                    current.turnaroundTime = currentTime;
                    current.waitingTime = current.turnaroundTime - current.burstTime;

                    System.out.println("Process " + current.pid + " completed.");

                    ProcessNode nextProcess = current.next;
                    removeProcess(current.pid);
                    current = nextProcess;

                    displayQueue();
                    continue;
                }
            }

            current = current.next;
            displayQueue();
        }
    }

    // remove completed process
    private void removeProcess(int pid) {
        if (head == null)
            return;

        ProcessNode temp = head;
        ProcessNode prev = tail;

        do {
            if (temp.pid == pid) {

                if (temp == head && temp == tail) {
                    head = tail = null;
                    return;
                }

                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);
    }

    // display circular queue
    public void displayQueue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Current Queue: ");
        ProcessNode temp = head;
        do {
            System.out.print("[P" + temp.pid + " RT:" + temp.remainingTime + "] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // calculate averages
    public void calculateAverages(ProcessNode[] processes) {
        int totalWT = 0;
        int totalTAT = 0;

        for (ProcessNode p : processes) {
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.println("\nAverage Waiting Time = " +
                (double) totalWT / processes.length);
        System.out.println("Average Turnaround Time = " +
                (double) totalTAT / processes.length);
    }
}

// Main class
public class RoundRobinScheduling {

    public static void main(String[] args) {

        int timeQuantum = 3;
        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);

        // storing references for average calculation
        ProcessNode[] processes = new ProcessNode[3];

        processes[0] = new ProcessNode(1, 10, 1);
        processes[1] = new ProcessNode(2, 5, 2);
        processes[2] = new ProcessNode(3, 8, 1);

        for (ProcessNode p : processes) {
            scheduler.addProcess(p.pid, p.burstTime, p.priority);
        }

        System.out.println("Starting Round Robin Scheduling\n");
        scheduler.execute();

        scheduler.calculateAverages(processes);
    }
}
