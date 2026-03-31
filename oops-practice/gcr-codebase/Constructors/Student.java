package javaConstructors;

//Base class
public class Student {

 // Access modifiers
 public int rollNumber;      // public
 protected String name;      // protected
 private double CGPA;        // private

 // Constructor
 Student(int rollNumber, String name, double CGPA) {
     this.rollNumber = rollNumber;
     this.name = name;
     this.CGPA = CGPA;
 }

 // Public getter for CGPA
 public double getCGPA() {
     return CGPA;
 }

 // Public setter for CGPA
 public void setCGPA(double CGPA) {
     if (CGPA >= 0 && CGPA <= 10) {
         this.CGPA = CGPA;
     } else {
         System.out.println("Invalid CGPA value");
     }
 }

 // Method to display student details
 public void displayStudentDetails() {
     System.out.println("Roll Number: " + rollNumber);
     System.out.println("Name: " + name);
     System.out.println("CGPA: " + CGPA);
 }
}

//Subclass
class PostgraduateStudent extends Student {

 String specialization;

 PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
     super(rollNumber, name, CGPA);
     this.specialization = specialization;
 }

 // Demonstrating use of protected member
 void displayPGDetails() {
     System.out.println("Postgraduate Student Name: " + name); // protected access
     System.out.println("Specialization: " + specialization);
     System.out.println("CGPA: " + getCGPA()); // private accessed via public method
 }

 // Main method
 public static void main(String[] args) {

     PostgraduateStudent pg = new PostgraduateStudent(
             101, "Aditya", 8.7, "Computer Science");

     pg.displayStudentDetails();
     System.out.println();

     // Modify CGPA using public method
     pg.setCGPA(9.1);

     pg.displayPGDetails();
 }
}

