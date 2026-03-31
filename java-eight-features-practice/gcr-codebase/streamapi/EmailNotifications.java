package streamapi;

import java.util.*;

public class EmailNotifications {

    public static void main(String[] args) {

        List<String> emails = Arrays.asList(
                "rahul@example.com",
                "sneha@example.com",
                "aman@example.com",
                "priya@example.com",
                "karan@example.com"
        );

        emails.forEach(email -> sendEmailNotification(email));
    }

    public static void sendEmailNotification(String email) {
        System.out.println("Sending notification email to: " + email);
    }
}
