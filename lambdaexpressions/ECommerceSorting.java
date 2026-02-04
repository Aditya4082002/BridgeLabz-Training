package lambdaexpressions;
import java.util.*;

class Product {
    int id;
    String name;
    double price;
    double rating;
    double discount;

    Product(int id, String name, double price, double rating, double discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " | " + price + " | " + rating + " | " + discount + "% off";
    }
}


public class ECommerceSorting {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
            new Product(1, "Laptop", 60000, 4.5, 10),
            new Product(2, "Phone", 30000, 4.7, 15),
            new Product(3, "Headphones", 2000, 4.2, 30)
        );

        // 🔹 Sort by Price (Low → High)
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("Sorted by Price:");
        products.forEach(System.out::println);

        // 🔹 Sort by Rating (High → Low)
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("\nSorted by Rating:");
        products.forEach(System.out::println);

        // 🔹 Sort by Discount (High → Low)
        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        System.out.println("\nSorted by Discount:");
        products.forEach(System.out::println);
    }
}
