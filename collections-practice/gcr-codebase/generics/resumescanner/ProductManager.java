package generics.resumescanner;

public class ProductManager extends JobRole {

    public ProductManager() {
        super("Product Manager", 2);
    }

    @Override
    public String[] requiredSkills() {
        return new String[]{"Communication", "Strategy", "Leadership", "Analytics"};
    }
}
