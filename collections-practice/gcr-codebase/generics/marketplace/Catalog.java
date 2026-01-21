package generics.marketplace;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Product<? extends Category>> products;

    public Catalog() {
        products = new ArrayList<>();
    }

    public void addProduct(Product<? extends Category> product) {
        products.add(product);
        System.out.println("Added: " + product.getName());
    }

    public void displayAll() {
        System.out.println("\n--- Catalog Items ---");
        for (Product<? extends Category> p : products) {
            System.out.println(p);
        }
    }
}
