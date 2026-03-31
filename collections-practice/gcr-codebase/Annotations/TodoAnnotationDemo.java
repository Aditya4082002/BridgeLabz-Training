package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Custom annotation definition
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// Class using the @Todo annotation
class ProjectTasks {

    @Todo(task = "Implement login feature", assignedTo = "Aditya", priority = "HIGH")
    public void login() {
        System.out.println("Login feature");
    }

    @Todo(task = "Add password reset functionality", assignedTo = "Rahul")
    public void resetPassword() {
        System.out.println("Reset password feature");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Priya", priority = "LOW")
    public void optimizeDatabase() {
        System.out.println("Optimize DB");
    }
}

// Retrieve annotation details using Reflection
public class TodoAnnotationDemo {

    public static void main(String[] args) {

        Method[] methods = ProjectTasks.class.getDeclaredMethods();

        System.out.println("Pending Tasks:");
        System.out.println("--------------");

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);

                System.out.println("Method     : " + method.getName());
                System.out.println("Task       : " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority   : " + todo.priority());
                System.out.println("--------------");
            }
        }
    }
}

