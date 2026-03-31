package DSA;

import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || k == 0) return new int[0];

        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // Remove indices out of current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements (not useful)
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Store result when first window is complete
            if (i >= k - 1) {
                result[i - k + 1] = arr[dq.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] maxValues = maxSlidingWindow(arr, k);

        System.out.println("Sliding Window Maximums:");
        for (int val : maxValues) {
            System.out.print(val + " ");
        }
    }
}
