package DSA;

import java.util.Stack;

class StockSpan {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>(); // stores indices

        // First day span is always 1
        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < n; i++) {

            // Pop while price on stack <= current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If empty, span is i+1 else difference of indices
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] span = calculateSpan(prices);

        System.out.println("Stock Prices:");
        for (int p : prices) {
            System.out.print(p + " ");
        }

        System.out.println("\nStock Span:");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}

