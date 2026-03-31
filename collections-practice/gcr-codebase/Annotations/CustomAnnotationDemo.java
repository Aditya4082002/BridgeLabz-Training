package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// 1️ Create Custom Annotation
@Retention(RetentionPolicy.RUNTIME)   // Needed for reflection
@Target(ElementType.METHOD)            // Can be applied to methods
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// 2️ Use Annotation in a Class
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Aditya")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}

// 3 Retrieve Annotation using Reflection
public class CustomAnnotationDemo {

    public static void main(String[] args) throws Exception {

        TaskManager manager = new TaskManager();
        Method method = manager.getClass().getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo info = method.getAnnotation(TaskInfo.class);

            System.out.println("Task Priority : " + info.priority());
            System.out.println("Assigned To   : " + info.assignedTo());
        }

        manager.completeTask();
    }
}

