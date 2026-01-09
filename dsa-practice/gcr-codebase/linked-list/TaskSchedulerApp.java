package linkedList;

// Node class
class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

// Circular Linked List
class TaskScheduler {
    TaskNode head;
    TaskNode current; // to track current task

    // add at beginning
    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // add at end
    public void addAtLast(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // add at specific position (1-based)
    public void addAtPosition(int id, String name, int priority, String dueDate, int position) {
        if (position == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        TaskNode temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // remove task by taskId
    public void removeTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = null;

        do {
            if (temp.taskId == taskId) {

                // only one node
                if (temp == head && temp.next == head) {
                    head = null;
                    current = null;
                    return;
                }

                // deleting head
                if (temp == head) {
                    TaskNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                    current = head;
                } else {
                    prev.next = temp.next;
                }

                System.out.println("Task removed successfully.");
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        System.out.println("Task not found.");
    }

    // view current task and move to next
    public void viewNextTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        displayTask(current);
        current = current.next;
    }

    // display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // search by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with priority: " + priority);
        }
    }

    // helper method
    private void displayTask(TaskNode task) {
        System.out.println("Task ID : " + task.taskId);
        System.out.println("Task Name : " + task.taskName);
        System.out.println("Priority : " + task.priority);
        System.out.println("Due Date : " + task.dueDate);
        System.out.println("---------------------");
    }
}

// Main class
public class TaskSchedulerApp {

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtBeginning(1, "Assignment", 1, "10-01-2026");
        scheduler.addAtLast(2, "Project", 2, "20-01-2026");
        scheduler.addAtLast(3, "Exam Prep", 1, "25-01-2026");
        scheduler.addAtPosition(4, "Meeting", 3, "12-01-2026", 2);

        System.out.println("All Tasks:");
        scheduler.displayTasks();

        System.out.println("\nView Current & Next Tasks:");
        scheduler.viewNextTask();
        scheduler.viewNextTask();

        System.out.println("\nSearch by Priority:");
        scheduler.searchByPriority(1);

        scheduler.removeTask(2);

        System.out.println("\nTasks After Deletion:");
        scheduler.displayTasks();
    }
}
