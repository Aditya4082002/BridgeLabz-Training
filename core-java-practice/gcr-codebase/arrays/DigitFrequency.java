//program to take a number as input find the frequency of each digit

import java.util.Scanner;

class DigitFrequency {
    public static void main(String[] args) {
        //create a Scanner object
        Scanner input = new Scanner(System.in);

        //Take input number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int copyNumber = number;
        int count = 0;

        //Find count of digits
        while (copyNumber > 0) {
            count++;
            copyNumber /= 10;
        }

        //Create array to store digits
        int[] digits = new int[count];

        copyNumber = number;
        int index = 0;

        //Extract digits and store in array
        while (copyNumber > 0) {
            digits[index] = copyNumber % 10;
            copyNumber /= 10;
            index++;
        }

        //Frequency array for digits 0–9
        int[] frequency = new int[10];

        //Find frequency of each digit
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        //Display frequency
        System.out.println("Digit Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s)");
            }
        }

        //closing the Scanner stream
        input.close();
    }
}
