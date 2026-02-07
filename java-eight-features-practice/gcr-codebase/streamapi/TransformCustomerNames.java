package streamapi;

import java.util.*;
import java.util.stream.*;

public class TransformCustomerNames {

    public static void main(String[] args) {

        List<String> customers = Arrays.asList(
                "rahul",
                "Aman",
                "sneha",
                "Priya",
                "karan"
        );

        List<String> transformedNames = customers.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Customer Names for Display:\n");

        transformedNames.forEach(System.out::println);
    }
}

