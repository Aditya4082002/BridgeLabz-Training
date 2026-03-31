package collectors;

import java.util.*;
import java.util.stream.*;

public class EmployeeSalaryCategorization {

    static class Employee {
        private String name;
        private String department;
        private double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Rahul", "IT", 70000),
                new Employee("Sneha", "HR", 50000),
                new Employee("Aman", "IT", 90000),
                new Employee("Priya", "Finance", 60000),
                new Employee("Karan", "HR", 55000),
                new Employee("Neha", "Finance", 75000)
        );

        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        System.out.println("Average Salary by Department:\n");

        avgSalaryByDept.forEach((dept, avgSalary) ->
                System.out.println(dept + " : " + avgSalary)
        );
    }
}
