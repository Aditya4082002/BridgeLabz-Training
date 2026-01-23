package collections;

import java.util.*;

public class ReverseQueue {

    public static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) return;

        int front = q.remove();   // remove front
        reverse(q);               // reverse remaining queue
        q.add(front);             // add removed element at end
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Original: " + q);

        reverse(q);

        System.out.println("Reversed: " + q);
    }
}
