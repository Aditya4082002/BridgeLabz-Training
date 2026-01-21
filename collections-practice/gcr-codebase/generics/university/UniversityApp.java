package generics.university;

public class UniversityApp {
    public static void main(String[] args) {

        // Computer Science Department (Exam Based)
        Course<ExamCourse> csDept = new Course<>("Computer Science Department");
        csDept.addCourse(new ExamCourse("CS101", "Data Structures", 4, 100));
        csDept.addCourse(new ExamCourse("CS102", "Operating Systems", 4, 100));

        // Management Department (Assignment Based)
        Course<AssignmentCourse> mgmtDept = new Course<>("Management Department");
        mgmtDept.addCourse(new AssignmentCourse("MG201", "Business Communication", 3, 5));
        mgmtDept.addCourse(new AssignmentCourse("MG202", "Marketing Basics", 3, 4));

        // Research Department (Research Based)
        Course<ResearchCourse> researchDept = new Course<>("Research Department");
        researchDept.addCourse(new ResearchCourse("RS301", "AI Research", 5, "Machine Learning Models"));
        researchDept.addCourse(new ResearchCourse("RS302", "Cyber Security Research", 5, "Network Attacks"));

        //Display using wildcard method
        Course.displayCourses(csDept.getAllCourses());
        Course.displayCourses(mgmtDept.getAllCourses());
        Course.displayCourses(researchDept.getAllCourses());
    }
}

