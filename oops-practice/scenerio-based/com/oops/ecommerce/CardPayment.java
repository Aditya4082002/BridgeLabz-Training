package com.oops.ecommerce;

class CardPayment implements Payment{
	public void pay(double amount) throws PaymentFailedException{
		if(amount <= 0) {
			throw new PaymentFailedException("Invalid amount.");
		}
		System.out.println("Card Payment Successful.");
	}
}
