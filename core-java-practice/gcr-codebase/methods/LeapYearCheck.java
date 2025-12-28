//program that takes a year as input and outputs the Year is a Leap Year or not
import java.util.Scanner;

class LeapYearCheck {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // Check Gregorian calendar condition
        if (year < 1582) {
            System.out.println("Year must be 1582 or later (Gregorian Calendar).");
            input.close();
            return;
        }

        // Check leap year
        boolean isLeap = isLeapYear(year);

        // Display result
        if (isLeap) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is NOT a Leap Year.");
        }
        //close scanner stream
        input.close();
    }

    // Method to check Leap Year
    static boolean isLeapYear(int year) {

        // Conditions for leap year
        if (year % 400 == 0){
            return true;
        }else if (year % 100 == 0){
            return false;
        }else{
            return year % 4 == 0;
        }
    }
}
