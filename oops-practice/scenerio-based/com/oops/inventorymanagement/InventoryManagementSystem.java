package com.oops.inventorymanagement;

public class InventoryManagementSystem {

	public static void main(String[] args) {

		Inventory inventory = new Inventory();

		Product p1 = new Product(1, "Keyboard", 20, 5);
		Product p2 = new Product(2, "Mouse", 10, 3);

		inventory.addProduct(p1);
		inventory.addProduct(p2);

		inventory.viewInventory();

		try {
			inventory.updateStock(1, 4); // low stock alert
			inventory.updateStock(2, 0); // low stock alert
			inventory.updateStock(2, -1); // exception
		} catch (OutOfStockException e) {
			System.out.println("Error: " + e.getMessage());
		}

		inventory.viewInventory();
	}
}
