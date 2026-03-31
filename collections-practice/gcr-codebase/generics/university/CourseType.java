package generics.university;

public abstract class CourseType {

    private String courseCode;
    private String courseName;
    private int credits;

    public CourseType(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    // every course type will have its own evaluation method
    public abstract String getEvaluationType();

    @Override
    public String toString() {
        return "Code: " + courseCode + ", Name: " + courseName +
                ", Credits: " + credits + ", Evaluation: " + getEvaluationType();
    }
}
