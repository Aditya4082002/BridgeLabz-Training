package generics.resumescanner;

public class SoftwareEngineer extends JobRole {

    public SoftwareEngineer() {
        super("Software Engineer", 1);
    }

    @Override
    public String[] requiredSkills() {
        return new String[]{"Java", "DSA", "OOP", "Git"};
    }
}
