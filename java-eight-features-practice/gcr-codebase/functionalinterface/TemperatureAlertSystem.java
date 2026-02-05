package functionalinterface;

import java.util.function.Predicate;

public class TemperatureAlertSystem {

    public static void main(String[] args) {

        double threshold = 40.0;

        Predicate<Double> temperatureAlert =
                temp -> temp > threshold;

        double currentTemperature = 45.5;

        if (temperatureAlert.test(currentTemperature)) {
            System.out.println("ALERT! Temperature crossed the threshold.");
        } else {
            System.out.println("Temperature is normal.");
        }
    }
}

