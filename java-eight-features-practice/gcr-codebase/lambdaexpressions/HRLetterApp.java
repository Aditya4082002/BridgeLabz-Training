package lambdaexpressions;

import java.util.*;

public class HRLetterApp {

    public static void main(String[] args) {

        List<String> employeeNames = Arrays.asList(
            "Ravi", "Anita", "Suresh", "Neha"
        );

        employeeNames.stream()
                     .map(String::toUpperCase)
                     .forEach(System.out::println);
    }
}
