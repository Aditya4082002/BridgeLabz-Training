package generics.resumescanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResumeScreenerApp {
    public static void main(String[] args) {

        // Resumes for different roles
        Resume<SoftwareEngineer> r1 = new Resume<>(
                "Aditya", 2,
                Arrays.asList("Java", "DSA", "OOP", "Git"),
                new SoftwareEngineer()
        );

        Resume<DataScientist> r2 = new Resume<>(
                "Rahul", 1,
                Arrays.asList("Python", "Machine Learning", "SQL", "Statistics"),
                new DataScientist()
        );

        Resume<ProductManager> r3 = new Resume<>(
                "Neha", 1,
                Arrays.asList("Communication", "Strategy", "Leadership"),
                new ProductManager()
        );

        // store multiple role resumes in one list using wildcard type
        List<Resume<? extends JobRole>> allResumes = new ArrayList<>();
        allResumes.add(r1);
        allResumes.add(r2);
        allResumes.add(r3);

        // run pipeline
        ScreeningPipeline.runPipeline(allResumes);
    }
}
