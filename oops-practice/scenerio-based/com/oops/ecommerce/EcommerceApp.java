package com.oops.ecommerce;

public class EcommerceApp {

	public static void main(String[] args) {
		Product product1 = new Product(101,"Laptop",82000);
		Product product2 = new Product(102,"Mouse",500);
		Product product3 = new Product(103,"Keyboard",1500);
		
		
		Customer customer1 = new Customer(11,"Aditya");
		
		Order order1 = new Order(1,customer1);
		order1.addProduct(product1);
		order1.addProduct(product2);
		
		Payment payment = new UpiPayment();
		
		order1.placeOrder(payment);
		
		order1.trackOrder();
		
		order1.cancelOder();
		
		order1.trackOrder();
	}

}
