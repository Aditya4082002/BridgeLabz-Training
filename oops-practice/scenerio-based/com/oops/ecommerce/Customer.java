package com.oops.ecommerce;

class Customer {
	private int customerId;
	private String name;
	
	Customer(int customerId,String name){
		this.customerId = customerId;
		this.name = name;
	}
	
	//getters
	public int getCustomerId() {
		return customerId;
	}
	
	public String getName() {
		return name;
	}
}
