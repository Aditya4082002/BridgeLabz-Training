package generics.warehouse;

public class Electronics extends WarehouseItem {
    private int warrantyMonths;

    public Electronics(String itemId, String name, int warrantyMonths) {
        super(itemId, name);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty: " + warrantyMonths + " months";
    }
}
