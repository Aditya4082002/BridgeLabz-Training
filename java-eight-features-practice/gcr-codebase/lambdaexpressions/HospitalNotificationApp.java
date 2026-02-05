package lambdaexpressions;

import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;     // EMERGENCY, MEDICATION, APPOINTMENT
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return type + " ALERT: " + message;
    }
}


public class HospitalNotificationApp {

    public static void main(String[] args) {

        List<Alert> alerts = Arrays.asList(
            new Alert("EMERGENCY", "Heart rate critical!"),
            new Alert("MEDICATION", "Take insulin at 8 AM"),
            new Alert("APPOINTMENT", "Doctor visit at 5 PM"),
            new Alert("EMERGENCY", "Oxygen level low!")
        );

        // 🔹 User wants to see only EMERGENCY alerts
        Predicate<Alert> emergencyOnly =
                alert -> alert.type.equals("EMERGENCY");

        System.out.println("Filtered Alerts:");
        alerts.stream()
              .filter(emergencyOnly)
              .forEach(System.out::println);
    }
}
