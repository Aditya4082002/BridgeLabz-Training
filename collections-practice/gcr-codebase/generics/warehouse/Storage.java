package generics.warehouse;
import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WarehouseItem> {

    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    // Store an item
    public void addItem(T item) {
        items.add(item);
        System.out.println("Added: " + item.getName());
    }

    // Remove item by ID
    public boolean removeItemById(String itemId) {
        for (T item : items) {
            if (item.getItemId().equals(itemId)) {
                items.remove(item);
                System.out.println("Removed: " + item.getName());
                return true;
            }
        }
        System.out.println("Item not found with ID: " + itemId);
        return false;
    }

    // Retrieve all items
    public List<T> getAllItems() {
        return items;
    }

    // Retrieve item by ID
    public T getItemById(String itemId) {
        for (T item : items) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    //Wildcard method: display items of any WarehouseItem type
    public static void displayItems(List<? extends WarehouseItem> itemsList) {
        System.out.println("\n--- Warehouse Storage Items ---");
        for (WarehouseItem item : itemsList) {
            System.out.println(item);
        }
    }
}
