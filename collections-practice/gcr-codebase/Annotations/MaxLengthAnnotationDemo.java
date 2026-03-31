package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

// Field-level annotation definition
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// User class with validation logic
class User {

    @MaxLength(10)
    private String username;

    public User(String username) {

        validateMaxLength(username);
        this.username = username;
    }

    private void validateMaxLength(String value) {
        try {
            Field field = this.getClass().getDeclaredField("username");

            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);

                if (value != null && value.length() > maxLength.value()) {
                    throw new IllegalArgumentException(
                        "Username length exceeds maximum allowed length of "
                        + maxLength.value()
                    );
                }
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Validation error", e);
        }
    }

    public String getUsername() {
        return username;
    }
}

// Test class
public class MaxLengthAnnotationDemo {

    public static void main(String[] args) {

        User user1 = new User("Aditya");
        System.out.println("Username accepted: " + user1.getUsername());

        User user2 = new User("VeryLongUsername");
        System.out.println("Username accepted: " + user2.getUsername());
    }
}

