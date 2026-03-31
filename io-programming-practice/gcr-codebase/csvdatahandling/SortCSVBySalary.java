package csvdatahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCSVBySalary {

    // Inner Employee class
    static class Employee {
        int id;
        String name;
        String department;
        double salary;

        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "ID=" + id +
                   ", Name=" + name +
                   ", Department=" + department +
                   ", Salary=" + salary;
        }
    }

    public static void main(String[] args) {

        String filePath = "employee.csv";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                employees.add(new Employee(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                ));
            }

            // Sort by salary (descending)
            Collections.sort(employees, new Comparator<Employee>() {
                public int compare(Employee e1, Employee e2) {
                    return Double.compare(e2.salary, e1.salary);
                }
            });

            // Print top 5 highest-paid employees
            System.out.println("Top 5 Highest-Paid Employees:");
            System.out.println("-----------------------------");

            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                System.out.println(employees.get(i));
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
        }
    }
}
