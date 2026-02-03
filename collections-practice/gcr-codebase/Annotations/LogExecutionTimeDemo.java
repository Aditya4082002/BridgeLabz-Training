package Annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Annotation definition
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

// Class with methods to be measured
class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1_000; i++) {
            // simulate small work
        }
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 10_000_000; i++) {
            // simulate heavy work
        }
    }

    public void normalMethod() {
        for (int i = 0; i < 5_000; i++) {
        }
    }
}

// Utility to execute and log time
public class LogExecutionTimeDemo {

    public static void main(String[] args) throws Exception {

        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long startTime = System.nanoTime();
                method.invoke(test);
                long endTime = System.nanoTime();

                long duration = endTime - startTime;

                System.out.println(
                    "Method: " + method.getName() +
                    " | Execution Time: " + duration + " ns"
                );
            }
        }
    }
}

