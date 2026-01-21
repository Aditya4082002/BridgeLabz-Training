package generics.marketplace;
public class DiscountUtil {

    // Generic Method
    public static <T extends Product<? extends Category>> void applyDiscount(T product, double percentage) {

        if (percentage <= 0 || percentage > 90) {
            throw new IllegalArgumentException("Discount must be between 1% to 90%");
        }

        double oldPrice = product.getPrice();
        double newPrice = oldPrice - (oldPrice * percentage / 100);

        product.setPrice(newPrice);

        System.out.println("Discount Applied: " + percentage + "% | " +
                product.getName() + " : " + oldPrice + " -> " + newPrice);
    }
}

