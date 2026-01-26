package streams;

import java.io.*;
import java.util.*;

public class EmployeeSerializationDemo {

    //Employee class (Serializable)
    static class Employee implements Serializable {
        private static final long serialVersionUID = 1L;

        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    //Serialize List<Employee> into file
    public static void saveEmployees(List<Employee> employees, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(employees);
            System.out.println("Employees saved to file: " + fileName);

        } catch (IOException e) {
            System.out.println("IOException while saving: " + e.getMessage());
        }
    }

    //Deserialize List<Employee> from file
    public static List<Employee> loadEmployees(String fileName) {
        List<Employee> employees = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees loaded from file: " + fileName);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("IOException while loading: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }

        return employees;
    }

    //Main Method
    public static void main(String[] args) {

        String fileName = "employees.dat";

        // Create Employee List
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 65000));
        employees.add(new Employee(103, "Carol", "Finance", 70000));

        //Serialize
        saveEmployees(employees, fileName);

        System.out.println();

        //Deserialize
        List<Employee> loadedEmployees = loadEmployees(fileName);

        System.out.println("---- Employees from File ----");
        for (Employee e : loadedEmployees) {
            System.out.println(e);
        }
    }
}

