package csvdatahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToStudent {

    // Inner Student class
    static class Student {
        private int id;
        private String name;
        private int age;
        private int marks;

        public Student(int id, String name, int age, int marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "Student [ID=" + id +
                   ", Name=" + name +
                   ", Age=" + age +
                   ", Marks=" + marks + "]";
        }
    }

    public static void main(String[] args) {

        String filePath = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header row
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Student s = new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3])
                );

                students.add(s);
            }

        } catch (IOException e) {
            System.out.println("Error reading the CSV file");
        }

        // Print all student objects
        System.out.println("Student Objects:");
        System.out.println("----------------");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
