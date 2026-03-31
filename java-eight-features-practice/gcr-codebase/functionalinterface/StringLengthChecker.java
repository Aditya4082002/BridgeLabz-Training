package functionalinterface;

import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {

        int maxLength = 20;

        Function<String, Integer> lengthFunction =
                message -> message.length();

        String message = "Functional Interfaces in Java";

        int length = lengthFunction.apply(message);

        if (length > maxLength) {
            System.out.println("Message exceeds character limit");
        } else {
            System.out.println("Message is within character limit");
        }
    }
}

