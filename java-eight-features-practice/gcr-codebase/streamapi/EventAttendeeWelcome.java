package streamapi;

import java.util.*;
import java.util.stream.*;

public class EventAttendeeWelcome {

    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
                "Rahul",
                "Sneha",
                "Aman",
                "Priya",
                "Karan"
        );

        System.out.println("Welcome Messages:\n");

        attendees.stream()
                .forEach(name -> 
                        System.out.println("Welcome to the Annual Tech Conference, " + name + "!")
                );
    }
}

