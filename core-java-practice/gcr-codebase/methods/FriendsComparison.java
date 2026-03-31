//program to find the youngest friends among 3 Amar, Akbar and Anthony based
//on their ages and tallest among the friends based on their heights
import java.util.Scanner;

class FriendsComparison {
    public static void main(String[] args) {

        //create a scanner object
        Scanner input = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Take input for age and height
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = input.nextInt();

            System.out.print("Enter height of " + names[i] + " (in cm): ");
            heights[i] = input.nextDouble();
        }

        // Find youngest and tallest
        String youngest = findYoungest(names, ages);
        String tallest = findTallest(names, heights);

        // Display result
        System.out.println("\nYoungest friend: " + youngest);
        System.out.println("Tallest friend : " + tallest);

        //close scanner stream
        input.close();
    }

    // Method to find the youngest friend
    static String findYoungest(String[] names, int[] ages) {

        int minAge = ages[0];
        int index = 0;

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                index = i;
            }
        }

        return names[index];
    }

    // Method to find the tallest friend
    static String findTallest(String[] names, double[] heights) {

        double maxHeight = heights[0];
        int index = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                index = i;
            }
        }

        return names[index];
    }
}
