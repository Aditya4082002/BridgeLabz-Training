class FootballTeamHeight {
    public static void main(String[] args) {

        int[] heights = new int[11];

        // Generate random heights between 150 and 250 cm
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + (int)(Math.random() * 101);
        }

        // Display heights
        System.out.print("Heights of players (in cm): ");
        for (int i = 0; i < heights.length; i++) {
            System.out.print(heights[i] + " ");
        }

        // Calculations
        int sum = findSum(heights);
        double mean = findMeanHeight(heights);
        int shortest = findShortestHeight(heights);
        int tallest = findTallestHeight(heights);

        // Display results
        System.out.println("\n\n--- Height Analysis ---");
        System.out.println("Shortest Height : " + shortest + " cm");
        System.out.println("Tallest Height  : " + tallest + " cm");
        System.out.println("Mean Height     : " + mean + " cm");
    }

    // Method to find sum of heights
    static int findSum(int[] heights) {

        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        return sum;
    }

    // Method to find mean height
    static double findMeanHeight(int[] heights) {

        int sum = findSum(heights);
        return sum / (double) heights.length;
    }

    // Method to find shortest height
    static int findShortestHeight(int[] heights) {

        int min = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < min) {
                min = heights[i];
            }
        }
        return min;
    }

    // Method to find tallest height
    static int findTallestHeight(int[] heights) {

        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > max) {
                max = heights[i];
            }
        }
        return max;
    }
}
