package generics.university;

public class ResearchCourse extends CourseType {

    private String researchTopic;

    public ResearchCourse(String courseCode, String courseName, int credits, String researchTopic) {
        super(courseCode, courseName, credits);
        this.researchTopic = researchTopic;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    @Override
    public String getEvaluationType() {
        return "Research-Based (Topic: " + researchTopic + ")";
    }
}
