package DSA;

import java.util.Stack;

class QueueUsingStacks {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    // Enqueue operation
    public void enqueue(int data) {
        s1.push(data);
        System.out.println("Enqueued: " + data);
    }

    // Dequeue operation
    public int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Transfer only if needed
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    // Display queue (optional)
    public void display() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");

        // Print s2 (front part)
        for (int i = s2.size() - 1; i >= 0; i--) {
            System.out.print(s2.get(i) + " ");
        }

        // Print s1 (rear part)
        for (int i = 0; i < s1.size(); i++) {
            System.out.print(s1.get(i) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.enqueue(40);

        queue.display();
    }
}
