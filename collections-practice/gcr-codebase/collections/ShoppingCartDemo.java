package collections;

import java.util.*;

class ShoppingCart {

    // HashMap: product -> price (store prices)
    private final Map<String, Double> priceMap = new HashMap<>();

    // LinkedHashMap: maintains insertion order (items added to cart)
    private final Map<String, Integer> cartItems = new LinkedHashMap<>();

    // Add product to store (catalog)
    public void addProductToStore(String product, double price) {
        if (product == null || product.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be > 0");
        }
        priceMap.put(product, price);
    }

    // Add product to cart
    public void addToCart(String product, int quantity) {
        if (!priceMap.containsKey(product)) {
            throw new IllegalArgumentException("Product not found in store: " + product);
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }

        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
    }

    // Remove product from cart
    public void removeFromCart(String product) {
        cartItems.remove(product);
    }

    // Display cart in insertion order
    public void displayCartInOrder() {
        System.out.println("---- Cart Items (Insertion Order) ----");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int qty = entry.getValue();
            double price = priceMap.get(product);

            System.out.println(product + " | Qty: " + qty + " | Price: " + price);
        }
    }

    // Display cart sorted by price using TreeMap
    public void displayCartSortedByPrice() {
        System.out.println("---- Cart Items (Sorted By Price) ----");

        // TreeMap: price -> list of products (handles same price products)
        Map<Double, List<String>> sortedByPrice = new TreeMap<>();

        for (String product : cartItems.keySet()) {
            double price = priceMap.get(product);

            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(product);
        }

        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            double price = entry.getKey();

            for (String product : entry.getValue()) {
                int qty = cartItems.get(product);
                System.out.println(product + " | Qty: " + qty + " | Price: " + price);
            }
        }
    }

    // Total Bill
    public double getTotalBill() {
        double total = 0;

        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int qty = entry.getValue();
            double price = priceMap.get(product);

            total += price * qty;
        }
        return total;
    }
}

public class ShoppingCartDemo {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        // Store products (HashMap)
        cart.addProductToStore("Milk", 50);
        cart.addProductToStore("Bread", 30);
        cart.addProductToStore("Eggs", 10);
        cart.addProductToStore("Butter", 60);

        // Add items (LinkedHashMap maintains order)
        cart.addToCart("Milk", 1);
        cart.addToCart("Bread", 2);
        cart.addToCart("Eggs", 6);
        cart.addToCart("Butter", 1);

        cart.displayCartInOrder();
        System.out.println();

        cart.displayCartSortedByPrice();
        System.out.println();

        System.out.println("Total Bill = " + cart.getTotalBill());
    }
}
