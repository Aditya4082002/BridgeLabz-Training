import java.util.Scanner;

class TemperatureConverter {

    // Function to convert Fahrenheit to Celsius
    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Function to convert Celsius to Fahrenheit
    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Function to take input and perform conversion
    static void takeInputAndConvert() {

        Scanner input = new Scanner(System.in);

        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Choose an option: ");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double f = input.nextDouble();
            double c = fahrenheitToCelsius(f);
            System.out.println("Temperature in Celsius: " + c);
        }
        else if (choice == 2) {
            System.out.print("Enter temperature in Celsius: ");
            double c = input.nextDouble();
            double f = celsiusToFahrenheit(c);
            System.out.println("Temperature in Fahrenheit: " + f);
        }
        else {
            System.out.println("Invalid choice");
        }
        input.close();
    }

    public static void main(String[] args) {
        takeInputAndConvert();
    }
}
