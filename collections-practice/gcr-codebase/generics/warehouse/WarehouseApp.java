package generics.warehouse;

public class WarehouseApp{
    public static void main(String[] args) {

        //Storage for Electronics
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("E101", "Laptop", 24));
        electronicsStorage.addItem(new Electronics("E102", "Smartphone", 12));

        //Storage for Groceries
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("G201", "Milk", "2026-02-10"));
        groceriesStorage.addItem(new Groceries("G202", "Rice", "2027-05-15"));

        //Storage for Furniture
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("F301", "Chair", "Wood"));
        furnitureStorage.addItem(new Furniture("F302", "Table", "Steel"));

        //Display using Wildcard Method
        Storage.displayItems(electronicsStorage.getAllItems());
        Storage.displayItems(groceriesStorage.getAllItems());
        Storage.displayItems(furnitureStorage.getAllItems());

        //Search Example
        Electronics found = electronicsStorage.getItemById("E101");
        System.out.println("\nFound Item: " + found);

        //Remove Example
        groceriesStorage.removeItemById("G201");

        //Display after removal
        Storage.displayItems(groceriesStorage.getAllItems());
    }
}
