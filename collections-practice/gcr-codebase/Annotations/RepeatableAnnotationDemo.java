package Annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// 1️ Container Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// 2️ Repeatable Annotation
@Repeatable(BugReports.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReport {
    String description();
}

// 3️ Use Repeatable Annotation
class SoftwareModule {

    @BugReport(description = "Null pointer exception on startup")
    @BugReport(description = "Memory leak when loading data")
    public void runModule() {
        System.out.println("Module is running...");
    }
}

// 4️ Retrieve Annotation using Reflection
public class RepeatableAnnotationDemo {

    public static void main(String[] args) throws Exception {

        Method method = SoftwareModule.class.getMethod("runModule");

        BugReport[] reports = method.getAnnotationsByType(BugReport.class);

        System.out.println("Bug Reports:");
        System.out.println("------------");

        for (BugReport report : reports) {
            System.out.println("- " + report.description());
        }
    }
}
