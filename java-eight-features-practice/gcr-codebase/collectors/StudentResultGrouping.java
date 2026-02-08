package collectors;

import java.util.*;
import java.util.stream.*;

public class StudentResultGrouping {

    static class Student {
        private String name;
        private String gradeLevel;

        public Student(String name, String gradeLevel) {
            this.name = name;
            this.gradeLevel = gradeLevel;
            
        }

        public String getName() {
            return name;
        }

        public String getGradeLevel() {
            return gradeLevel;
        }
    }

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Rahul", "Grade 10"),
                new Student("Sneha", "Grade 9"),
                new Student("Aman", "Grade 10"),
                new Student("Priya", "Grade 8"),
                new Student("Karan", "Grade 9"),
                new Student("Neha", "Grade 8")
        );

        Map<String, List<String>> groupedStudents = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGradeLevel,
                        Collectors.mapping(Student::getName, Collectors.toList())
                ));

        System.out.println("Students grouped by grade level:\n");

        groupedStudents.forEach((grade, names) -> {
            System.out.println(grade + " -> " + names);
        });
        
        
    }
}

