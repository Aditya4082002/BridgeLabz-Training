import java.util.Scanner;

class Quadratic {
    public static void main(String[] args) {

        //create a scanner object
        Scanner input = new Scanner(System.in);

        // Take input values
        System.out.print("Enter value of a: ");
        double a = input.nextDouble();

        System.out.print("Enter value of b: ");
        double b = input.nextDouble();

        System.out.print("Enter value of c: ");
        double c = input.nextDouble();

        // Find roots
        double[] roots = findRoots(a, b, c);

        // Display result
        if (roots.length == 2) {
            System.out.println("Root 1: " + roots[0]);
            System.out.println("Root 2: " + roots[1]);
        } else if (roots.length == 1) {
            System.out.println("Root: " + roots[0]);
        } else {
            System.out.println("No real roots (delta is negative).");
        }

        //close scanner stream
        input.close();
    }

    // Method to find roots of quadratic equation
    static double[] findRoots(double a, double b, double c) {

        // Calculate delta
        double delta = Math.pow(b, 2) - 4 * a * c;

        // If delta > 0 = two real roots
        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        }

        // If delta == 0 = one real root
        if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        }

        // If delta < 0 = no real roots
        return new double[0];
    }
}
