package generics.marketplace;
public class BookCategory implements Category {

    private String categoryName;
    private double minPrice;
    private double maxPrice;

    public BookCategory(String categoryName, double minPrice, double maxPrice) {
        this.categoryName = categoryName;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public String getCategoryName() {
        return "Book - " + categoryName;
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
