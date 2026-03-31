//Program to find the maximum number of handshakes among students.
import java.util.Scanner;

class HandshakeCalculator {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take input for number of students
        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();

        // Calculate handshakes
        int handshakes = calculateHandshakes(numberOfStudents);

        // Display result
        System.out.println(
            "The maximum number of possible handshakes among " +
            numberOfStudents + " students is " + handshakes
        );

        //close scanner stream
        input.close();
    }

    // Method to calculate number of handshakes using combination formula
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}