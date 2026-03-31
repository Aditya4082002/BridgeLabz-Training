package com.oops.ecommerce;
import java.util.*;

class Order {
	private int orderId;
	private String status;
	Customer customer;
	List<Product> products = new ArrayList<>();
	
	Order(int orderId,Customer customer){
		this.orderId = orderId;
		this.customer = customer;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public double calculateTotal() {
		double total = 0;
		
		for(Product product : products) {
			total += product.getPrice();
		}
		
		return total;
	}
	
	public void placeOrder(Payment payment) {
		try {
			double amount = calculateTotal();
			payment.pay(amount);
			status = "Placed";
			System.out.println("Order palced successfull.");
		}catch(PaymentFailedException e) {
			status = "Failed";
			System.out.println("Order failed."+ e.getMessage());
		}
	}
	
	public void cancelOder() {
		if(status.equals("Placed")) {
			status = "Cancelled";
			System.out.println("Order");
		}else {
			System.out.println("Order cannot be cancelled");
		}
	}
	
	public void trackOrder() {
		System.out.println("Current Order Status : "+ status);
	}
}
