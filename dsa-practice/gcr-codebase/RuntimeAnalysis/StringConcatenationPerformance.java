package RuntimeAnalysis;

public class StringConcatenationPerformance {

    // Using String
    public static long usingString(int n) {
        String s = "";
        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            s = s + "a";
        }

        long end = System.nanoTime();
        return (end - start);
    }

    // Using StringBuilder
    public static long usingStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            sb.append("a");
        }

        long end = System.nanoTime();
        return (end - start);
    }

    // Using StringBuffer
    public static long usingStringBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            sb.append("a");
        }

        long end = System.nanoTime();
        return (end - start);
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 1000000};

        for (int n : sizes) {
            System.out.println("=======================================");
            System.out.println("Operations Count (N): " + n);

            // String
            if (n <= 100000) {
                long stringTime = usingString(n);
                System.out.println("String Time : " + stringTime + " ns");
            } else {
                System.out.println("String Time : Unusable for " + n + " (Too Slow)");
            }

            // StringBuilder
            long builderTime = usingStringBuilder(n);
            System.out.println("StringBuilder Time : " + builderTime + " ns");

            // StringBuffer
            long bufferTime = usingStringBuffer(n);
            System.out.println("StringBuffer Time : " + bufferTime + " ns");

            System.out.println("=======================================");
        }
    }
}
