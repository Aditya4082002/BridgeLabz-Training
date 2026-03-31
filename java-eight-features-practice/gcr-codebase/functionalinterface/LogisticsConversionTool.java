package functionalinterface;

interface UnitConverter {

    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    static double milesToKm(double miles) {
        return miles / 0.621371;
    }

    static double kgToLbs(double kg) {
        return kg * 2.20462;
    }

    static double lbsToKg(double lbs) {
        return lbs / 2.20462;
    }
}


public class LogisticsConversionTool {

    public static void main(String[] args) {

        double distanceKm = 100;
        double weightKg = 50;

        System.out.println(distanceKm + " km = "+ UnitConverter.kmToMiles(distanceKm) + " miles");

        System.out.println(weightKg + " kg = "+ UnitConverter.kgToLbs(weightKg) + " lbs");
    }
}

