package reflection;

import java.lang.reflect.Field;

//Class with private field
class Person {

 private int age = 25;

 public int getAge() {
     return age;
 }
}

//Reflection demo
public class AccessPrivateFieldDemo {

 public static void main(String[] args) throws Exception {

     Person person = new Person();

     Field field = Person.class.getDeclaredField("age");
     field.setAccessible(true);

     field.set(person, 40);

     int updatedAge = (int) field.get(person);

     System.out.println("Updated age using reflection: " + updatedAge);
 }
}
