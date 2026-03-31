package reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Sample class to map data into
class Students {

    private int id;
    private String name;
    private int age;

    public void display() {
        System.out.println("ID   : " + id);
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}

// Custom Object Mapper
class ObjectMapperUtil {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {

        try {
            T obj = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {

                String fieldName = entry.getKey();
                Object value = entry.getValue();

                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(obj, value);
            }

            return obj;

        } catch (Exception e) {
            throw new RuntimeException("Object mapping failed", e);
        }
    }
}

// Test class
public class CustomObjectMapperDemo {

    public static void main(String[] args) {

        Map<String, Object> data = new HashMap<>();
        data.put("id", 101);
        data.put("name", "Aditya");
        data.put("age", 21);

        Students student = ObjectMapperUtil.toObject(Students.class, data);
        student.display();
    }
}

