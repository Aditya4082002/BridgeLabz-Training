class RandomNumberAnalysis {
    public static void main(String[] args) {

        RandomNumberAnalysis object = new RandomNumberAnalysis();

        // Generate 5 random 4-digit numbers
        int[] numbers = object.generate4DigitRandomArray(5);

        // Display generated numbers
        System.out.print("Generated Numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        // Find average, min and max
        double[] result = object.findAverageMinMax(numbers);

        // Display results
        System.out.println("\nAverage Value : " + result[0]);
        System.out.println("Minimum Value : " + result[1]);
        System.out.println("Maximum Value : " + result[2]);
    }

    // Method to generate array of 4-digit random numbers
    public int[] generate4DigitRandomArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            // 4-digit random number (1000 to 9999)
            arr[i] = (int)(Math.random() * 9000) + 1000;
        }

        return arr;
    }

    // Method to find average, min and max of array
    public double[] findAverageMinMax(int[] numbers) {

        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }

        double average = sum / (double) numbers.length;

        return new double[]{average, min, max};
    }
}
