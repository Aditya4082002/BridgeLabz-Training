package generics.warehouse;

public abstract class WarehouseItem {
    private String itemId;
    private String name;

    public WarehouseItem(String itemId, String name) {
        this.itemId = itemId;
        this.name = name;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    // Each item type must define its category
    public abstract String getCategory();

    @Override
    public String toString() {
        return "ItemID: " + itemId + ", Name: " + name + ", Category: " + getCategory();
    }
}
