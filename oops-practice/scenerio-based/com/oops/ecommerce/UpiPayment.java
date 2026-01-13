package com.oops.ecommerce;

class UpiPayment implements Payment{
	public void pay(double amount) throws PaymentFailedException{
		if(amount <= 0) {
			throw new PaymentFailedException("Invalid amount.");
		}
		else if(amount > 100000) {
			throw new PaymentFailedException("UPI limit exceeded.");
		}
		System.out.println("UPI Payment Successful.");
	}
}
