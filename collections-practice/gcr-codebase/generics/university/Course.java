package generics.university;

import java.util.ArrayList;
import java.util.List;

public class Course<T extends CourseType> {

    private String departmentName;
    private List<T> courses;

    public Course(String departmentName) {
        this.departmentName = departmentName;
        this.courses = new ArrayList<>();
    }

    public void addCourse(T course) {
        courses.add(course);
        System.out.println("Added: " + course.getCourseName() + " to " + departmentName);
    }

    public List<T> getAllCourses() {
        return courses;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    //Wildcard method: Print ANY type of course list
    public static void displayCourses(List<? extends CourseType> courseList) {
        System.out.println("\n--- Course List ---");
        for (CourseType c : courseList) {
            System.out.println(c);
        }
    }
}

