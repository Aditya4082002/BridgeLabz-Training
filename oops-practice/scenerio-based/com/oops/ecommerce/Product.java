package com.oops.ecommerce;
//product class
class Product {
	//attributes
	private int productId;
	private String name;
	private double price;
	
	//constructor
	Product(int productId,String name,double price){
		this.productId = productId;
		this.name = name;
		this.price = price;
	}
	
	//getters
	public int getProductId() {
		return productId;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
}
