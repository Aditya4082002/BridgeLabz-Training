package com.oops.inventorymanagement;

class EmailAlertService implements AlertService {
	public void sendLowStockAlert(Product product) {
		System.out.println("ALERT: Low stock for " + product.getProductName() + " (Available: " + product.getQuantity() + ")");
	}
}