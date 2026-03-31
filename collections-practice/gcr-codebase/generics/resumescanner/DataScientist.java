package generics.resumescanner;

public class DataScientist extends JobRole {

    public DataScientist() {
        super("Data Scientist", 1);
    }

    @Override
    public String[] requiredSkills() {
        return new String[]{"Python", "Machine Learning", "Statistics", "SQL"};
    }
}
