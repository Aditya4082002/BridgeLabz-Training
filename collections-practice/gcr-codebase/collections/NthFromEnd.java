package collections;

import java.util.*;

public class NthFromEnd {

    public static <T> T nthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be >= 1");
        }

        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        // Move fast ahead by N steps
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                throw new IllegalArgumentException("N is greater than list size");
            }
            fast.next();
        }

        // Move both until fast reaches end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        // slow is now at Nth from end
        return slow.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        System.out.println(nthFromEnd(list, n)); // Output: D
    }
}

