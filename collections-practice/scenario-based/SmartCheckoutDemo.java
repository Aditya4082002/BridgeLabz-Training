package scenario;
import java.util.*;

public class SmartCheckoutDemo {

    //Customer class 
    static class Customer {
        String name;
        List<String> items; // list of item names

        public Customer(String name, List<String> items) {
            this.name = name;
            this.items = items;
        }
    }

    //SmartCheckout
    static class SmartCheckout {

        // Queue of customers
        private Queue<Customer> customerQueue = new LinkedList<>();

        // Item -> Price
        private Map<String, Integer> priceMap = new HashMap<>();

        // Item -> Stock
        private Map<String, Integer> stockMap = new HashMap<>();

        // Add item to store
        public void addItem(String item, int price, int stock) {
            priceMap.put(item, price);
            stockMap.put(item, stock);
        }

        // Add customer to queue
        public void addCustomer(Customer customer) {
            customerQueue.add(customer);
            System.out.println(customer.name + " added to queue");
        }

        // Remove & process next customer
        public void processCustomer() {
            if (customerQueue.isEmpty()) {
                System.out.println("No customers in queue");
                return;
            }

            Customer customer = customerQueue.poll();
            System.out.println("\nProcessing customer: " + customer.name);

            int totalBill = 0;

            for (String item : customer.items) {

                if (!priceMap.containsKey(item)) {
                    System.out.println(item + " not found!");
                    continue;
                }

                int stock = stockMap.get(item);
                if (stock <= 0) {
                    System.out.println(item + " is out of stock!");
                    continue;
                }

                int price = priceMap.get(item);
                totalBill += price;

                // Update stock
                stockMap.put(item, stock - 1);

                System.out.println("Purchased: " + item + " | Price: " + price);
            }

            System.out.println("Total Bill for " + customer.name + " = ₹" + totalBill);
        }

        // Display stock
        public void displayStock() {
            System.out.println("\n---- Current Stock ----");
            for (String item : stockMap.keySet()) {
                System.out.println(item + " -> " + stockMap.get(item));
            }
            System.out.println("-----------------------");
        }
    }

    public static void main(String[] args) {

        SmartCheckout checkout = new SmartCheckout();

        // Add items to store
        checkout.addItem("Milk", 50, 5);
        checkout.addItem("Bread", 30, 3);
        checkout.addItem("Eggs", 10, 10);

        // Create customers
        Customer c1 = new Customer("Alice", Arrays.asList("Milk", "Bread"));
        Customer c2 = new Customer("Bob", Arrays.asList("Eggs", "Milk", "Eggs"));

        // Add customers to queue
        checkout.addCustomer(c1);
        checkout.addCustomer(c2);

        // Process customers
        checkout.processCustomer();
        checkout.processCustomer();

        // Display remaining stock
        checkout.displayStock();
    }
}

