package generics.university;
public class ExamCourse extends CourseType {

    private int examMarks;

    public ExamCourse(String courseCode, String courseName, int credits, int examMarks) {
        super(courseCode, courseName, credits);
        this.examMarks = examMarks;
    }

    public int getExamMarks() {
        return examMarks;
    }

    @Override
    public String getEvaluationType() {
        return "Exam-Based (" + examMarks + " marks)";
    }
}
