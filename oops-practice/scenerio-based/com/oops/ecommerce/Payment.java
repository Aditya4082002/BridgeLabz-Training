package com.oops.ecommerce;

interface Payment {
	public void pay(double amount) throws PaymentFailedException;
}
