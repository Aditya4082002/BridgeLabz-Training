package generics.university;

public class AssignmentCourse extends CourseType {

    private int totalAssignments;

    public AssignmentCourse(String courseCode, String courseName, int credits, int totalAssignments) {
        super(courseCode, courseName, credits);
        this.totalAssignments = totalAssignments;
    }

    public int getTotalAssignments() {
        return totalAssignments;
    }

    @Override
    public String getEvaluationType() {
        return "Assignment-Based (" + totalAssignments + " assignments)";
    }
}
