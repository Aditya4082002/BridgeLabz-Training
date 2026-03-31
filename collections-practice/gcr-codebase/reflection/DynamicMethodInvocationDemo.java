package reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

// Class with multiple operations
class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

// Reflection demo
public class DynamicMethodInvocationDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MathOperations operations = new MathOperations();

        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        System.out.print("Enter first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter second number: ");
        int b = scanner.nextInt();

        try {
            Method method = MathOperations.class.getMethod(
                    methodName, int.class, int.class
            );

            Object result = method.invoke(operations, a, b);

            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Invalid method name or parameters");
        }
    }
}

