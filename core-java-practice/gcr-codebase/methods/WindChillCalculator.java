//Program calculate the wind chill temperature given the temperature and wind speed
import java.util.Scanner;

class WindChillCalculator {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter temperature (in Fahrenheit): ");
        double temperature = input.nextDouble();

        System.out.print("Enter wind speed (in miles per hour): ");
        double windSpeed = input.nextDouble();

        // Calculate wind chill
        double windChill = calculateWindChill(temperature, windSpeed);

        // Display result
        System.out.println( "The Wind Chill Temperature is: " + windChill );
        
        //close scanner stream
        input.close();
    }

    // Method to calculate Wind Chill Temperature
    public static double calculateWindChill(double temperature, double windSpeed) {

        double windChill = 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);

        return windChill;
    }
}