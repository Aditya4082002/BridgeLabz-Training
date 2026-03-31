package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

// Annotation definition
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// User class with annotated fields
class Users {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    public Users(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }
}

// JSON serialization utility
class JsonSerializer {

    public static String toJson(Object obj) {

        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {

            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);

                try {
                    Object value = field.get(obj);

                    if (!first) {
                        json.append(", ");
                    }

                    json.append("\"")
                        .append(annotation.name())
                        .append("\": ");

                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }

                    first = false;

                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Serialization error", e);
                }
            }
        }

        json.append("}");
        return json.toString();
    }
}

// Test class
public class JsonFieldAnnotationDemo {

    public static void main(String[] args) {

        Users user = new Users("Aditya", 21, "aditya@example.com");

        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
