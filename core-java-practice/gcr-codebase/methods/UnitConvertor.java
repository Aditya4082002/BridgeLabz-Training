class UnitConvertor {
    public static void main(String[] args) {

        double km = 10;
        double miles = 6.2;
        double meters = 5;
        double feet = 16.4;

        System.out.println("Kilometers to Miles: " + convertKmToMiles(km));
        System.out.println("Miles to Kilometers: " + convertMilesToKm(miles));
        System.out.println("Meters to Feet: " + convertMetersToFeet(meters));
        System.out.println("Feet to Meters: " + convertFeetToMeters(feet));
    }

    // Method to convert kilometers to miles
    public static double convertKmToMiles(double km) {

        double kmTomiles = 0.621371;
        return km * kmTomiles;
    }

    // Method to convert miles to kilometers
    public static double convertMilesToKm(double miles) {

        double milesTokm = 1.60934;
        return miles * milesTokm;
    }

    // Method to convert meters to feet
    public static double convertMetersToFeet(double meters) {

        double metersToFeet = 3.28084;
        return meters * metersToFeet;
    }

    // Method to convert feet to meters
    public static double convertFeetToMeters(double feet) {

        double feetToMeters = 0.3048;
        return feet * feetToMeters;
    }
}
