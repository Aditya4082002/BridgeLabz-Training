package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Class-level annotation definition
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

// Service class with restricted methods
class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully.");
    }

    @RoleAllowed("ADMIN")
    public void viewAllReports() {
        System.out.println("Viewing all reports.");
    }
}

// Role validation and method invocation
public class RoleBasedAccessDemo {

    // Simulated current user role
    private static String currentUserRole = "USER";

    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();
        Method[] methods = AdminService.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(RoleAllowed.class)) {

                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);

                if (currentUserRole.equals(roleAllowed.value())) {
                    method.invoke(service);
                } else {
                    System.out.println(
                        "Access Denied! Method: " + method.getName()
                    );
                }
            }
        }

        System.out.println("Switching role to ADMIN...\n");
        currentUserRole = "ADMIN";

        for (Method method : methods) {

            if (method.isAnnotationPresent(RoleAllowed.class)) {

                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);

                if (currentUserRole.equals(roleAllowed.value())) {
                    method.invoke(service);
                }
            }
        }
    }
}
