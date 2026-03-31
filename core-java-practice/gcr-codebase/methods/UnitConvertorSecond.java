class UnitConvertorSecond {
    public static void main(String[] args) {

        double yards = 5;
        double feet = 15;
        double meters = 2;
        double inches = 12;

        System.out.println("Yards to Feet: " + convertYardsToFeet(yards));
        System.out.println("Feet to Yards: " + convertFeetToYards(feet));
        System.out.println("Meters to Inches: " + convertMetersToInches(meters));
        System.out.println("Inches to Meters: " + convertInchesToMeters(inches));
        System.out.println("Inches to Centimeters: " + convertInchesToCentimeters(inches));
    }

    // Method to convert yards to feet
    public static double convertYardsToFeet(double yards) {

        double yardsToFeet = 3;
        return yards * yardsToFeet;
    }

    // Method to convert feet to yards
    public static double convertFeetToYards(double feet) {

        double feetToYards = 0.333333;
        return feet * feetToYards;
    }

    // Method to convert meters to inches
    public static double convertMetersToInches(double meters) {

        double metersToinches = 39.3701;
        return meters * metersToinches;
    }

    // Method to convert inches to meters
    public static double convertInchesToMeters(double inches) {

        double inchesToMeters = 0.0254;
        return inches * inchesToMeters;
    }

    // Method to convert inches to centimeters
    public static double convertInchesToCentimeters(double inches) {

        double inchesToCm = 2.54;
        return inches * inchesToCm;
    }
}
