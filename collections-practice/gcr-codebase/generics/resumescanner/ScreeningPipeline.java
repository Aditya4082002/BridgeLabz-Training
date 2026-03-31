package generics.resumescanner;

import java.util.List;

public class ScreeningPipeline {

    //Wildcard: can accept ANY job role type list
    public static void runPipeline(List<? extends Resume<? extends JobRole>> resumes) {

        System.out.println("\n--- AI Resume Screening Results ---");

        for (Resume<? extends JobRole> r : resumes) {

            boolean eligible = ResumeScreeningUtil.isEligible(r);

            System.out.println(r);
            System.out.println("Result: " + (eligible ? "Selected" : "Rejected"));
            System.out.println("-----------------------------------");
        }
    }
}

