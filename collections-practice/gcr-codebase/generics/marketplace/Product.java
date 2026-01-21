package generics.marketplace;

public class Product<T extends Category> {

    private String productId;
    private String name;
    private double price;
    private T category;

    public Product(String productId, String name, double price, T category) {
        this.productId = productId;
        this.name = name;
        this.category = category;

        // price range validation
        if (price < category.getMinPrice() || price > category.getMaxPrice()) {
            throw new IllegalArgumentException(
                    "Invalid price ₹" + price +
                    " for " + category.getCategoryName() +
                    " (Allowed ₹" + category.getMinPrice() + " to ₹" + category.getMaxPrice() + ")"
            );
        }
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        if (price < category.getMinPrice() || price > category.getMaxPrice()) {
            throw new IllegalArgumentException("New price is out of range for " + category.getCategoryName());
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + productId +
                ", Name: " + name +
                ", Price: ₹" + price +
                ", Category: " + category.getCategoryName();
    }
}
