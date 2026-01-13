package com.oops.courseRegistration;

public class StudentCourseRegistrationSystem {

    public static void main(String[] args) {

        Student student = new Student(101, "Aditya");
        RegistrationService service = new CourseRegistrationService();

        service.enroll(student, "Java");
        service.enroll(student, "Data Structures");
        service.enroll(student, "Operating Systems");
        service.enroll(student, "DBMS"); // exceeds limit

        student.viewCourses();

        student.assignGrade("Java", "A");
        student.assignGrade("Data Structures", "B+");

        student.viewGrades();

        service.drop(student, "Operating Systems");
        student.viewCourses();
    }
}