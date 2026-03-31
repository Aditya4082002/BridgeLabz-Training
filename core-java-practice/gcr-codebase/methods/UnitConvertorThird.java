class UnitConvertor {
    public static void main(String[] args) {

        double fahrenheit = 98.6;
        double celsius = 37;
        double pounds = 150;
        double kilograms = 68;
        double gallons = 5;
        double liters = 10;

        System.out.println("Fahrenheit to Celsius: " + convertFarhenheitToCelsius(fahrenheit));

        System.out.println("Celsius to Fahrenheit: " + convertCelsiusToFarhenheit(celsius));

        System.out.println("Pounds to Kilograms: " + convertPoundsToKilograms(pounds));

        System.out.println("Kilograms to Pounds: " + convertKilogramsToPounds(kilograms));

        System.out.println("Gallons to Liters: " + convertGallonsToLiters(gallons));

        System.out.println("Liters to Gallons: " + convertLitersToGallons(liters));
    }

    // Method to convert Fahrenheit to Celsius
    public static double convertFarhenheitToCelsius(double farhenheit) {

        double farhenheitToCelsius = (farhenheit - 32) * 5 / 9;
        return farhenheitToCelsius;
    }

    // Method to convert Celsius to Fahrenheit
    public static double convertCelsiusToFarhenheit(double celsius) {

        double celsiusToFarhenheit = (celsius * 9 / 5) + 32;
        return celsiusToFarhenheit;
    }

    // Method to convert pounds to kilograms
    public static double convertPoundsToKilograms(double pounds) {

        double poundsToKilograms = 0.453592;
        return pounds * poundsToKilograms;
    }

    // Method to convert kilograms to pounds
    public static double convertKilogramsToPounds(double kilograms) {

        double kilogramsToPounds = 2.20462;
        return kilograms * kilogramsToPounds;
    }

    // Method to convert gallons to liters
    public static double convertGallonsToLiters(double gallons) {

        double gallonsToLiters = 3.78541;
        return gallons * gallonsToLiters;
    }

    // Method to convert liters to gallons
    public static double convertLitersToGallons(double liters) {

        double litersToGallons = 0.264172;
        return liters * litersToGallons;
    }
}
