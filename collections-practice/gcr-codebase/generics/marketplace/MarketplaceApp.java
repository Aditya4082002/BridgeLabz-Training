package generics.marketplace;

public class MarketplaceApp {
    public static void main(String[] args) {

        // Create categories
        BookCategory fiction = new BookCategory("Fiction", 100, 1500);
        BookCategory education = new BookCategory("Education", 200, 3000);

        ClothingCategory mens = new ClothingCategory("Men", 300, 5000);

        GadgetCategory mobile = new GadgetCategory("Mobile", 5000, 80000);

        // Create products
        Product<BookCategory> book1 = new Product<>("B101", "Harry Potter", 499, fiction);
        Product<BookCategory> book2 = new Product<>("B102", "Java Notes", 999, education);

        Product<ClothingCategory> cloth1 = new Product<>("C201", "Men T-Shirt", 799, mens);

        Product<GadgetCategory> gadget1 = new Product<>("G301", "OnePlus Phone", 31000, mobile);

        // Add to catalog
        Catalog catalog = new Catalog();
        catalog.addProduct(book1);
        catalog.addProduct(book2);
        catalog.addProduct(cloth1);
        catalog.addProduct(gadget1);

        catalog.displayAll();

        // Apply discounts
        System.out.println("\n--- Discount Section ---");
        DiscountUtil.applyDiscount(book1, 10);
        DiscountUtil.applyDiscount(gadget1, 20);

        catalog.displayAll();
    }
}
