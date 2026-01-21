package generics.warehouse;

public class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String itemId, String name, String expiryDate) {
        super(itemId, name);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String getCategory() {
        return "Groceries";
    }

    @Override
    public String toString() {
        return super.toString() + ", Expiry Date: " + expiryDate;
    }
}
