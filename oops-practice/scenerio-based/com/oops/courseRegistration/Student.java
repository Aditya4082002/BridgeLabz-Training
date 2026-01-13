package com.oops.courseRegistration;
import java.util.*;

class Student extends Person {

    private List<CourseEnrollment> enrollments = new ArrayList<>();
    private static final int MAX_COURSES = 3;

    Student(int id, String name) {
        super(id, name);
    }

    public void addCourse(String course) throws CourseLimitExceededException {
        if (enrollments.size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Course limit exceeded (Max 3)");
        }

        enrollments.add(new CourseEnrollment(course));
        System.out.println(course + " enrolled successfully");
    }

    public void dropCourse(String course) {
        Iterator<CourseEnrollment> it = enrollments.iterator();
        while (it.hasNext()) {
            if (it.next().getCourseName().equals(course)) {
                it.remove();
                System.out.println(course + " dropped successfully");
                return;
            }
        }
        System.out.println("Course not found");
    }

    public void assignGrade(String course, String grade) {
        for (CourseEnrollment ce : enrollments) {
            if (ce.getCourseName().equals(course)) {
                ce.setGrade(grade);
                return;
            }
        }
        System.out.println("Course not found for grade assignment");
    }

    public void viewCourses() {
        System.out.println("\nEnrolled Courses:");
        for (CourseEnrollment ce : enrollments) {
            System.out.println(ce.getCourseName());
        }
    }

    public void viewGrades() {
        System.out.println("\nGrades for " + name + ":");
        for (CourseEnrollment ce : enrollments) {
            System.out.println(ce.getCourseName() + " : " + ce.getGrade());
        }
    }
}
