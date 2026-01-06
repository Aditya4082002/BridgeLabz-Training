package oopsPillars;

// interface
interface Discountable {

    double applyDiscount();

    String getDiscountDetails();
}

// abstract class
abstract class FoodItem {

    private String itemName;
    private double price;
    private int quantity;

    public abstract double calculateTotalPrice();

    public void setDetails(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    protected double getPrice() {
        return price;
    }

    protected int getQuantity() {
        return quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName +
               ", Price: " + price +
               ", Quantity: " + quantity;
    }
}

// VegItem subclass
class VegItem extends FoodItem implements Discountable {

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }

    public String getDiscountDetails() {
        return "Veg item discount 10 percent";
    }
}

// NonVegItem subclass
class NonVegItem extends FoodItem implements Discountable {

    public double calculateTotalPrice() {
        double basePrice = getPrice() * getQuantity();
        double extraCharge = basePrice * 0.20;
        return basePrice + extraCharge;
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    public String getDiscountDetails() {
        return "Non veg item discount 5 percent";
    }
}

// main class
public class OnlineFoodDeliverySystem {

    public static void processOrder(FoodItem[] items) {

        for (FoodItem item : items) {

            double totalPrice = item.calculateTotalPrice();
            double discount = 0;

            if (item instanceof Discountable) {
                discount = ((Discountable) item).applyDiscount();
            }

            System.out.println(item.getItemDetails());
            System.out.println("Total Price: " + totalPrice);
            System.out.println("Discount: " + discount);
            System.out.println("Final Amount: " + (totalPrice - discount));

            if (item instanceof Discountable) {
                System.out.println(
                    ((Discountable) item).getDiscountDetails()
                );
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        FoodItem item1 = new VegItem();
        FoodItem item2 = new NonVegItem();

        item1.setDetails("Paneer Burger", 150, 2);
        item2.setDetails("Chicken Pizza", 300, 1);

        FoodItem[] orderItems = { item1, item2 };

        processOrder(orderItems);
    }
}
