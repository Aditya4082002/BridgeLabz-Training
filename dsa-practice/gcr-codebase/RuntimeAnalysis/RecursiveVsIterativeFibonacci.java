package RuntimeAnalysis;

public class RecursiveVsIterativeFibonacci {

    // Recursive Fibonacci
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1, sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {

        int[] testValues = {10, 30, 50};

        for (int n : testValues) {

            System.out.println("=======================================");
            System.out.println("Fibonacci N = " + n);

            // Recursive (avoid very large due to unfeasible runtime)
            if (n <= 30) {
                long recStart = System.nanoTime();
                int recAns = fibonacciRecursive(n);
                long recEnd = System.nanoTime();

                System.out.println("Recursive Result : " + recAns);
                System.out.println("Recursive Time   : " + (recEnd - recStart) + " ns");
            } else {
                System.out.println("Recursive Result : Skipped (Too Slow for N = " + n + ")");
            }

            // Iterative
            long itStart = System.nanoTime();
            int itAns = fibonacciIterative(n);
            long itEnd = System.nanoTime();

            System.out.println("Iterative Result : " + itAns);
            System.out.println("Iterative Time   : " + (itEnd - itStart) + " ns");

            System.out.println("=======================================");
        }
    }
}
