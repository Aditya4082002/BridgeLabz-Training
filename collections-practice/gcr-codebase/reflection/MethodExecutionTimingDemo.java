package reflection;

import java.lang.reflect.Method;

//Class whose methods will be timed
class TaskProcessor {

 public void quickTask() {
     for (int i = 0; i < 1_000; i++) {
     }
 }

 public void mediumTask() {
     for (int i = 0; i < 1_000_000; i++) {
     }
 }

 public void slowTask() {
     for (int i = 0; i < 10_000_000; i++) {
     }
 }
}

//Reflection-based timing utility
public class MethodExecutionTimingDemo {

 public static void main(String[] args) throws Exception {

     TaskProcessor processor = new TaskProcessor();
     Method[] methods = TaskProcessor.class.getDeclaredMethods();

     System.out.println("Method Execution Time:");
     System.out.println("----------------------");

     for (Method method : methods) {

         if (method.getParameterCount() == 0) {

             long startTime = System.nanoTime();
             method.invoke(processor);
             long endTime = System.nanoTime();

             long duration = endTime - startTime;

             System.out.println(
                 "Method: " + method.getName() +
                 " | Time: " + duration + " ns"
             );
         }
     }
 }
}
