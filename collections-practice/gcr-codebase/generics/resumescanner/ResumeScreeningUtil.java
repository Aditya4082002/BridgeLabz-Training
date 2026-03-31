package generics.resumescanner;

import java.util.HashSet;
import java.util.Set;

public class ResumeScreeningUtil {

    //Generic method: checks eligibility for ANY resume role type
    public static <T extends JobRole> boolean isEligible(Resume<T> resume) {

        // Experience check
        if (resume.getExperience() < resume.getJobRole().getMinExperience()) {
            return false;
        }

        // Skill match check
        Set<String> candidateSkills = new HashSet<>(resume.getSkills());

        for (String required : resume.getJobRole().requiredSkills()) {
            if (!candidateSkills.contains(required)) {
                return false;
            }
        }

        return true;
    }
}

