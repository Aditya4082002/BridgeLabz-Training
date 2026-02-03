package reflection;

import java.lang.reflect.Field;

//Class with private static field
class Configuration {

 private static String API_KEY = "OLD_KEY";

 public static String getApiKey() {
     return API_KEY;
 }
}

//Reflection demo
public class ModifyStaticFieldDemo {

 public static void main(String[] args) throws Exception {

     Field field = Configuration.class.getDeclaredField("API_KEY");
     field.setAccessible(true);

     // For static fields, pass null as the object instance
     field.set(null, "NEW_SECURE_KEY");

     String updatedKey = (String) field.get(null);
     System.out.println("Updated API_KEY: " + updatedKey);
 }
}
