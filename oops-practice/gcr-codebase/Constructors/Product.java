package javaConstructors;

public class Product {

    // Instance variables
    String productName;
    double price;

    // Class variable (shared)
    static int totalProducts = 0;

    // Constructor
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    // Instance method
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    // Class method
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    // Main method
    public static void main(String[] args) {

        Product product1 = new Product("Laptop", 55000);
        Product product2 = new Product("Mobile", 25000);
        Product product3 = new Product("Headphones", 3000);

        product1.displayProductDetails();
        System.out.println();

        product2.displayProductDetails();
        System.out.println();

        Product.displayTotalProducts(); // class method call
    }
}
