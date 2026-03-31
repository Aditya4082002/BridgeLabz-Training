package generics.resumescanner;
public abstract class JobRole {

    private String roleName;
    private int minExperience;

    public JobRole(String roleName, int minExperience) {
        this.roleName = roleName;
        this.minExperience = minExperience;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getMinExperience() {
        return minExperience;
    }

    // each role will have different skills requirement
    public abstract String[] requiredSkills();

    @Override
    public String toString() {
        return "Role: " + roleName + ", Min Experience: " + minExperience + " years";
    }
}
