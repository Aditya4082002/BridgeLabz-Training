//program to divide N number of chocolates among M children
import java.util.Scanner;

class ChocolateDistribution {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = input.nextInt();

        System.out.print("Enter number of children: ");
        int numberOfChildren = input.nextInt();

        // Find chocolates per child and remaining chocolates
        int[] result = divideChocolates(numberOfChocolates, numberOfChildren);

        // Display result
        System.out.println("Each child gets " + result[0] + " chocolates.");
        System.out.println("Remaining chocolates: " + result[1]);
        
        //close scanner stream
        input.close();
    }

    // Method to calculate chocolates per child and remaining chocolates
    public static int[] divideChocolates(int chocolates, int children) {

        int chocolatesPerChild = chocolates / children;
        int remainingChocolates = chocolates % children;

        return new int[]{chocolatesPerChild, remainingChocolates};
    }
}