package Annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// 1️ Custom Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

// 2️ Class using the annotation
class ServiceManager {

    @ImportantMethod
    public void startService() {
        System.out.println("Service started");
    }

    @ImportantMethod(level = "MEDIUM")
    public void stopService() {
        System.out.println("Service stopped");
    }

    public void helperMethod() {
        System.out.println("Helper method");
    }
}

// 3️ Retrieve annotation using Reflection
public class ImportantMethodDemo {

    public static void main(String[] args) {

        Method[] methods = ServiceManager.class.getDeclaredMethods();

        System.out.println("Important Methods:");
        System.out.println("------------------");

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = method.getAnnotation(ImportantMethod.class);

                System.out.println("Method Name : " + method.getName());
                System.out.println("Level       : " + im.level());
                System.out.println("------------------");
            }
        }
    }
}

