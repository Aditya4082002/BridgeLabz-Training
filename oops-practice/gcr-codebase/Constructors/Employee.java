package javaConstructors;

//Base class
class Employee {

 // Access modifiers
 public int employeeID;          // public
 protected String department;    // protected
 private double salary;          // private

 // Constructor
 Employee(int employeeID, String department, double salary) {
     this.employeeID = employeeID;
     this.department = department;
     this.salary = salary;
 }

 // Public method to modify salary
 public void setSalary(double salary) {
     if (salary > 0) {
         this.salary = salary;
     } else {
         System.out.println("Invalid salary amount");
     }
 }

 // Public getter for salary
 public double getSalary() {
     return salary;
 }

 // Display employee details
 public void displayEmployeeDetails() {
     System.out.println("Employee ID: " + employeeID);
     System.out.println("Department: " + department);
     System.out.println("Salary: ₹" + salary);
 }
}

//Subclass
class Manager extends Employee {

 String designation;

 Manager(int employeeID, String department, double salary, String designation) {
     super(employeeID, department, salary);
     this.designation = designation;
 }

 // Demonstrating access to public and protected members
 void displayManagerDetails() {
     System.out.println("Employee ID: " + employeeID);     // public access
     System.out.println("Department: " + department);     // protected access
     System.out.println("Salary: ₹" + getSalary());        // private via getter
     System.out.println("Designation: " + designation);
 }

 // Main method
 public static void main(String[] args) {

     Manager mgr = new Manager( 501, "IT", 75000, "Project Manager");

     mgr.displayEmployeeDetails();
     System.out.println();

     // Modify salary using public method
     mgr.setSalary(85000);

     mgr.displayManagerDetails();
 }
}