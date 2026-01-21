package generics.resumescanner;

import java.util.List;

public class Resume<T extends JobRole> {

    private String candidateName;
    private int experience;
    private List<String> skills;
    private T jobRole;

    public Resume(String candidateName, int experience, List<String> skills, T jobRole) {
        this.candidateName = candidateName;
        this.experience = experience;
        this.skills = skills;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperience() {
        return experience;
    }

    public List<String> getSkills() {
        return skills;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return "Candidate: " + candidateName +
                ", Exp: " + experience + " years" +
                ", Applied Role: " + jobRole.getRoleName() +
                ", Skills: " + skills;
    }
}
