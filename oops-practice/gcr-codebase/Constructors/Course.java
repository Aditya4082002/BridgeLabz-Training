package javaConstructors;

public class Course {

    // Instance variables
    String courseName;
    int duration;
    double fee;

    // Class variable
    static String instituteName = "ABC Institute";

    // Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: ₹" + fee);
    }

    // Class method
    static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    // Main method for testing
    public static void main(String[] args) {

        Course c1 = new Course("Java Full Stack", 6, 45000);
        Course c2 = new Course("Python Data Science", 5, 50000);

        c1.displayCourseDetails();
        System.out.println();

        c2.displayCourseDetails();
        System.out.println();

        // Update institute name for all courses
        Course.updateInstituteName("XYZ Technologies");

        System.out.println("After updating institute name:\n");
        c1.displayCourseDetails();
    }
}

