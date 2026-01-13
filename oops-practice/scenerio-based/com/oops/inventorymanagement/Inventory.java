package com.oops.inventorymanagement;

import java.util.*;

class Inventory {
	private List<Product> products = new ArrayList<>();

	public void addProduct(Product product) {
		products.add(product);
		System.out.println("Product added: " + product.getProductName());
	}

	public void updateStock(int productId, int newQuantity) throws OutOfStockException {
		for (Product p : products) {
			if (p.getProductId() == productId) {

				if (newQuantity < 0) {
					throw new OutOfStockException("Stock cannot be negative");
				}

				p.updateQuantity(newQuantity);
				System.out.println("Stock updated for " + p.getProductName());

				if (p.getQuantity() <= p.getLowStockLimit()) {
					AlertService alert = new EmailAlertService();
					alert.sendLowStockAlert(p);
				}
				return;
			}
		}
		System.out.println("Product not found");
	}

	public void viewInventory() {
		System.out.println("\nCurrent Inventory:");
		for (Product p : products) {
			System.out.println(p.getProductId() + " | " + p.getProductName() + " | Qty: " + p.getQuantity());
		}
	}
}