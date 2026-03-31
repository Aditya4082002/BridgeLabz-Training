package reflection;

import java.lang.reflect.Constructor;

//Student class
class Student {

 private int id;
 private String name;

 public Student() {
     this.id = 1;
     this.name = "Default Student";
 }

 public Student(int id, String name) {
     this.id = id;
     this.name = name;
 }

 public void display() {
     System.out.println("ID   : " + id);
     System.out.println("Name : " + name);
 }
}

//Reflection demo
public class CreateObjectUsingReflection {

 public static void main(String[] args) throws Exception {

     Class<?> clazz = Class.forName("reflection.Student");

     Constructor<?> constructor =
             clazz.getConstructor(int.class, String.class);

     Object obj = constructor.newInstance(101, "Aditya");

     Student student = (Student) obj;
     student.display();
 }
}

