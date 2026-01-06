package scenrioBase;

import java.util.ArrayList;
import java.util.List;

public class StudentReportGenerator {

    // Custom Exception
    static class InvalidMarkException extends Exception {
        InvalidMarkException(String message) {
            super(message);
        }
    }

    // Student class
    static class Student {
        private String name;
        private String[] subjects;
        private int[] marks;

        Student(String name, String[] subjects, int[] marks)
                throws InvalidMarkException {

            if (subjects.length != marks.length) {
                throw new InvalidMarkException("Subjects and marks count mismatch");
            }

            for (int mark : marks) {
                if (mark < 0 || mark > 100) {
                    throw new InvalidMarkException("Marks must be between 0 and 100");
                }
            }

            this.name = name;
            this.subjects = subjects;
            this.marks = marks;
        }

        String getName() {
            return name;
        }

        String[] getSubjects() {
            return subjects;
        }

        int[] getMarks() {
            return marks;
        }
    }

    // Report Generator logic
    static class ReportService {

        private List<Student> students = new ArrayList<>();

        // Add student record
        void addStudent(Student student) {
            students.add(student);
        }

        // Calculate average marks
        double calculateAverage(int[] marks) {
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }
            return (double) total / marks.length;
        }

        // Assign grade
        String assignGrade(double average) {

            if (average >= 80) {
                return "A";
            } else if (average >= 60) {
                return "B";
            } else if (average >= 40) {
                return "C";
            } else {
                return "Fail";
            }
        }

        // Display report cards
        void displayReports() {

            for (Student s : students) {

                System.out.println("Student Name: " + s.getName());
                System.out.println("Subjects and Marks:");

                String[] subjects = s.getSubjects();
                int[] marks = s.getMarks();

                for (int i = 0; i < subjects.length; i++) {
                    System.out.println(subjects[i] + ": " + marks[i]);
                }

                double average = calculateAverage(marks);
                String grade = assignGrade(average);

                System.out.printf("Average: %.2f%n", average);
                System.out.println("Grade: " + grade);
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        ReportService service = new ReportService();

        String[] subjects = { "Maths", "Science", "English" };

        try {
            Student student1 = new Student("Aditya",subjects,new int[] { 85, 90, 78 });

            Student student2 = new Student("Rahul",subjects,new int[] { 60, 55, 65 });

            service.addStudent(student1);
            service.addStudent(student2);

        } catch (InvalidMarkException e) {
            System.out.println(e.getMessage());
        }

        service.displayReports();
    }
}
