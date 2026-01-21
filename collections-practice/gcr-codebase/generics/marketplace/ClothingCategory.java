package generics.marketplace;

public class ClothingCategory implements Category {

    private String categoryName;
    private double minPrice;
    private double maxPrice;

    public ClothingCategory(String categoryName, double minPrice, double maxPrice) {
        this.categoryName = categoryName;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public String getCategoryName() {
        return "Clothing - " + categoryName;
    }

    @Override
    public double getMinPrice() {
        return minPrice;
    }

    @Override
    public double getMaxPrice() {
        return maxPrice;
    }
}
