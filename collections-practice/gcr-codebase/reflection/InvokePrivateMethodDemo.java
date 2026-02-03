package reflection;

import java.lang.reflect.Method;

//Class with private method
class Calculator {

 private int multiply(int a, int b) {
     return a * b;
 }
}

//Reflection demo
public class InvokePrivateMethodDemo {

 public static void main(String[] args) throws Exception {

     Calculator calculator = new Calculator();

     Method method = Calculator.class.getDeclaredMethod(
             "multiply", int.class, int.class
     );

     method.setAccessible(true);

     int result = (int) method.invoke(calculator, 5, 4);

     System.out.println("Result of private multiply method: " + result);
 }
}

